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
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
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

    @NonFinal
    @Value("${jwt.valid-duration}")
    protected long VALID_DURATION;

    @NonFinal
    @Value("${jwt.refreshable-duration}")
    protected long REFRESHABLE_DURATION;

    public IntrospectResponse introspect(IntrospectRequest request)
            throws JOSEException, ParseException {
        var token = request.getToken();
        boolean isValid = true;

        try {
            verifyToken(token, false);

            // Kiểm tra trong DB xem token đã bị vô hiệu hóa chưa
            Optional<UserToken> optionalUserToken = userTokenRepository.findByToken(token);
            if (optionalUserToken.isPresent()) {
                isValid = optionalUserToken.get().isValid(); // nếu đã logout, isValid = false
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
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        boolean authenticated = passwordEncoder.matches(request.getPassword(),
                user.getPassword());
        if (!authenticated)
            throw new AppException(ErrorCode.INVALID_CREDENTIALS);

        // Vô hiệu hóa các token cũ của user
        userTokenRepository.invalidateAllActiveTokensByUserId(user.getId());

        TokenResult tokenResult = generateToken(user, request.isRememberMe());
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
        System.out.println("run at here 6 ");
        userTokenRepository.save(userToken);

        System.out.println("Login successful for user: " + request.getUsername());
        return AuthenticationResponse.builder()
                .token(tokenResult.getToken())
                .authenticated(true)
                .build();
    }

    // Tạo JWT cho user dựa trên thông tin của họ.
    private TokenResult generateToken(User user, boolean rememberMe) {
        long duration = rememberMe ? Duration.ofDays(7).getSeconds() : Duration.ofDays(1).getSeconds();

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())  // Định danh user
                .issuer("SpringBootDatabase.com") // Hệ thống phát hành token
                .issueTime(new Date()) // Ngày phát hành
                .expirationTime(new Date(
                        Instant.now().plus(VALID_DURATION, ChronoUnit.SECONDS).toEpochMilli()
                )) // Ngày hết hạn
                .jwtID(UUID.randomUUID().toString()) // ID duy nhất của token
                .claim("scope", buildScope(user)) // Quyền của user
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes())); // Ký token với khóa bí mật
            return new TokenResult(jwsObject.serialize(), duration); // Trả về token dưới dạng chuỗi
        } catch (JOSEException e) {
            log.error("Cannot create token", e);
            throw new RuntimeException(e);
        }
    }

    private SignedJWT verifyToken(String token, boolean isRefresh) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiryTime = (isRefresh)
                ? new Date(signedJWT.getJWTClaimsSet().getIssueTime().toInstant().plus(REFRESHABLE_DURATION, ChronoUnit.SECONDS).toEpochMilli())
                : signedJWT.getJWTClaimsSet().getExpirationTime();

        boolean verified = signedJWT.verify(verifier);

        if (!(verified && expiryTime.after(new Date()))) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }

        String jwtId = signedJWT.getJWTClaimsSet().getJWTID();
        if (userTokenRepository.existsById(jwtId)) {
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

        TokenResult tokenResult = generateToken(user, false);

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
