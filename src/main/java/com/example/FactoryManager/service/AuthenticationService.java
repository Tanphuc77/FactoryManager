package com.example.FactoryManager.service;


import com.example.FactoryManager.dto.request.AuthenticationRequest;
import com.example.FactoryManager.dto.request.IntrospectRequest;
import com.example.FactoryManager.dto.request.LogoutRequest;
import com.example.FactoryManager.dto.request.RefreshRequest;
import com.example.FactoryManager.dto.response.AuthenticationResponse;
import com.example.FactoryManager.dto.response.IntrospectResponse;
import com.example.FactoryManager.dto.response.TokenResult;
import com.example.FactoryManager.entity.Role;
import com.example.FactoryManager.entity.User;
import com.example.FactoryManager.entity.UserToken;
import com.example.FactoryManager.enums.UserStatus;
import com.example.FactoryManager.exception.AppException;
import com.example.FactoryManager.exception.ErrorCode;
import com.example.FactoryManager.repository.UserRepository;
import com.example.FactoryManager.repository.UserTokenRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

    UserRepository userRepository;
    UserTokenRepository userTokenRepository;

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        var token = request.getToken();
        boolean isValid = true;

        try {
            verifyToken(token, false);

            // Kiểm tra trong DB xem token đã bị vô hiệu hóa chưa
            Optional<UserToken> optionalUserToken = userTokenRepository.findByToken(token);
            if (optionalUserToken.isPresent()) {
                UserToken userToken = optionalUserToken.get();

                isValid = userToken.isValid();

                // Kiểm tra hết hạn của token: chuyển LocalDateTime thành Date
                Date expirationTime = Date.from(userToken.getExpiryAt().atZone(ZoneId.systemDefault()).toInstant());
                if (expirationTime.before(new Date())) {
                    isValid = false; // Token đã hết hạn
                }
            } else {
                isValid = false; // Token không tồn tại trong DB
            }
        } catch (AppException e) {
            isValid = false;
        }

        return IntrospectResponse.builder()
                .valid(isValid)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USERNAME_DOES_NOT_EXIST));

        boolean authenticated = passwordEncoder.matches(request.getPassword(),
                user.getPassword());
        if (!authenticated)
            throw new AppException(ErrorCode.INVALID_CREDENTIALS);

        if(user.getStatus().equals(UserStatus.INACTIVE))
            throw new AppException(ErrorCode.USER_INACTIVE);

        // Vô hiệu hóa các token cũ của user
        userTokenRepository.invalidateAllActiveTokensByUserId(user.getId());

        TokenResult tokenResult = generateToken(user);
        UserToken userToken = UserToken.builder()
                .user(user)
                .token(tokenResult.getToken())
                .tokenType("Bearer")
                .deviceInfo("WEB")
                .issuedAt(LocalDateTime.now())
                .expiryAt(LocalDateTime.now().plusSeconds(tokenResult.getDuration()))
                .isValid(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userTokenRepository.save(userToken);

        System.out.println("Login successful for user: " + request.getUsername());
        return AuthenticationResponse.builder()
                .token(tokenResult.getToken())
                .expiryAt(LocalDateTime.now().plusSeconds(tokenResult.getDuration()))
                .authenticated(true)
                .build();
    }

    // Tạo JWT cho user dựa trên thông tin của họ.
    private TokenResult generateToken(User user) {
        long duration = Duration.ofDays(7).getSeconds(); // save 7 date

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())  // Định danh user
                .issuer("SpringBootDatabase.com") // Hệ thống phát hành token
                .issueTime(new Date()) // Ngày phát hành
                .expirationTime(new Date(Instant.now().plusSeconds(duration).toEpochMilli())) // Ngày hết hạn dựa vào rememberMe
                .jwtID(UUID.randomUUID().toString()) // ID duy nhất của token
                .claim("scope", buildScope(user)) // Quyền của user
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return new TokenResult(jwsObject.serialize(), duration);
        } catch (JOSEException e) {
            log.error("Cannot create token", e);
            throw new RuntimeException(e);
        }
    }

    private SignedJWT verifyToken(String token, boolean isRefresh) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        boolean verified = signedJWT.verify(verifier);

        // Kiểm tra nếu token hợp lệ và chưa hết hạn
        if (!(verified && expiryTime.after(new Date()))) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }

        // Kiểm tra trong DB xem token đã bị vô hiệu hóa chưa
        String jwtId = signedJWT.getJWTClaimsSet().getJWTID();
        Optional<UserToken> optionalUserToken = userTokenRepository.findById(jwtId);
        if (optionalUserToken.isPresent() && !optionalUserToken.get().isValid()) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }

        return signedJWT;
    }


    public void logout(LogoutRequest request) throws ParseException, JOSEException {
        try {
            verifyToken(request.getToken(), true); // xác minh tính hợp lệ

            userTokenRepository.findByToken(request.getToken())
                    .ifPresent(token -> {
                        token.setValid(false);
                        token.setUpdatedAt(LocalDateTime.now());
                        userTokenRepository.save(token);
                    });
        } catch (AppException e) {
            log.info("Token is invalid or expired");
        }
    }

    public AuthenticationResponse refreshToken(RefreshRequest request) throws ParseException, JOSEException {
        SignedJWT signedJWT = verifyToken(request.getToken(), true);

        String jwtId = signedJWT.getJWTClaimsSet().getJWTID();
        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        LocalDateTime expiryAt = expiryTime.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        // Vô hiệu hóa token cũ
        UserToken oldToken = userTokenRepository.findById(jwtId).orElse(null);
        if (oldToken != null) {
            oldToken.setValid(false);
            oldToken.setUpdatedAt(LocalDateTime.now());
            userTokenRepository.save(oldToken);
        }

        // Tạo token mới
        String username = signedJWT.getJWTClaimsSet().getSubject();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.UNAUTHENTICATED));

        TokenResult tokenResult = generateToken(user);

        UserToken newToken = UserToken.builder()
                .id(jwtId)
                .user(user)
                .token(tokenResult.getToken())
                .tokenType("Bearer")
                .deviceInfo("WEB")
                .issuedAt(LocalDateTime.now())
                .expiryAt(LocalDateTime.now().plusSeconds(tokenResult.getDuration()))
                .isValid(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userTokenRepository.save(newToken);

        return AuthenticationResponse.builder()
                .token(tokenResult.getToken())
                .authenticated(true)
                .build();
    }

    // Xây dựng quyền của user dưới dạng chuỗi.
    private String buildScope(User user) {
        StringJoiner stringJoiner = new StringJoiner(" ");

        Role role = user.getRole(); // chỉ 1 role
        if (role != null) {
            stringJoiner.add("ROLE_" + role.getName());

            if (role.getPermission() != null && !role.getPermission().isEmpty()) {
                System.out.println("Permissions of role " + role.getName() + ": " + role.getPermission());
                role.getPermission().forEach(permission -> stringJoiner.add(permission.getName()));
            } else {
                System.out.println("No permissions found for role: " + role.getName());
            }

        }

        return stringJoiner.toString();
    }

}
