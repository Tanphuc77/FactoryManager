package com.example.FactoryManager.configuration;

import com.example.FactoryManager.constant.PredefinedRole;
import com.example.FactoryManager.exception.AppException;
import com.example.FactoryManager.exception.ErrorCode;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    // get role user login
    public static String getCurrentRole() {
        return SecurityContextHolder.getContext().getAuthentication()// get information user securityContext
                .getAuthorities().stream() // get list role
                .findFirst().get().getAuthority(); // "ROLE_ADMIN", "ROLE_SUPER_ADMIN", ...
    }

    public static String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    // Check Admin
    public static void checkForbiddenAdminToModify(String targetRoleName) {
        String currentRole = getCurrentRole();
        if ("ROLE_ADMIN".equalsIgnoreCase(currentRole)) {
            if (PredefinedRole.ADMIN_ROLE.equalsIgnoreCase(targetRoleName)
                    || PredefinedRole.SUPER_ADMIN_ROLE.equalsIgnoreCase(targetRoleName)) {
                throw new AppException(ErrorCode.ROLE_NOT_ALLOWED);
            }
        }
    }

    // Check Super Admin
    public static void checkForbiddenSuperAdminToModifySelf(String targetUsername) {
        String currentUsername = getCurrentUsername();
        String currentRole = getCurrentRole();
        if ("ROLE_SUPER_ADMIN".equalsIgnoreCase(currentRole) && currentUsername.equalsIgnoreCase(targetUsername)) {
            throw new AppException(ErrorCode.ROLE_NOT_ALLOWED);
        }
    }
}

