package com.example.FactoryManager.configuration;

import com.example.FactoryManager.constant.PredefinedRole;
import com.example.FactoryManager.entity.Role;
import com.example.FactoryManager.entity.User;
import com.example.FactoryManager.enums.UserStatus;
import com.example.FactoryManager.exception.AppException;
import com.example.FactoryManager.exception.ErrorCode;
import com.example.FactoryManager.repository.RoleRepository;
import com.example.FactoryManager.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Value("${default.superadmin.password}")
    private String defaultPassword;

    /**
     * Tạo tài khoản Super Admin mặc định nếu chưa tồn tại trong hệ thống.
     * Chỉ tạo duy nhất 1 tài khoản có role SUPPER_ADMIN.
     * Username: "Admin", Mật khẩu: lấy từ file cấu hình, Role: SUPPER_ADMIN, ProjectManager: true, Status: ACTIVE
     */
    @PostConstruct
    public void init() {

        if (userRepository.countByRole_Name(PredefinedRole.SUPER_ADMIN_ROLE) == 0) {

            Role superAdminRole = roleRepository.findByName(PredefinedRole.SUPER_ADMIN_ROLE)
                    .orElseThrow(() -> new AppException(ErrorCode.SUPER_ADMIN_ROLE_NOT_FOUND));

            User superAdmin = new User();
            superAdmin.setUsername("Admin");
            superAdmin.setPassword(new BCryptPasswordEncoder().encode(defaultPassword));
            superAdmin.setFirstname("Admin");
            superAdmin.setLastname("Super");
            superAdmin.setRole(superAdminRole);
            superAdmin.setProjectManager(true);
            superAdmin.setStatus(UserStatus.ACTIVE);

            userRepository.save(superAdmin);
        }
    }
}

