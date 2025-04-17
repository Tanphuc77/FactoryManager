package com.example.FactoryManager.configuration;

import com.example.FactoryManager.constant.PredefinedRole;
import com.example.FactoryManager.exception.AppException;
import com.example.FactoryManager.exception.ErrorCode;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static String getCurrentRole() {
        return SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities().stream().findFirst().get().getAuthority(); // "ROLE_ADMIN", "ROLE_SUPER_ADMIN", ...
    }

    public static void checkForbiddenAdminToModify(String targetRoleName) {
        String currentRole = getCurrentRole();
        if ("ROLE_ADMIN".equalsIgnoreCase(currentRole)) {
            if (PredefinedRole.ADMIN_ROLE.equalsIgnoreCase(targetRoleName)
                    || PredefinedRole.SUPER_ADMIN_ROLE.equalsIgnoreCase(targetRoleName)) {
                throw new AppException(ErrorCode.ROLE_NOT_ALLOWED);
            }
        }
    }
}

