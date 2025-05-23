package com.example.FactoryManager.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(401, "Uauthenticated", HttpStatus.UNAUTHORIZED),
    INVALID_KEY(400, "Uncategorized error", HttpStatus.BAD_REQUEST),
    FORBIDDEN(403, "You do not have permission", HttpStatus.FORBIDDEN),
    USERNAME_ALREADY_EXISTS(400, "Username already exists", HttpStatus.BAD_REQUEST),
    COMPANY_NOT_FOUND(400,"Company not found" ,HttpStatus.BAD_REQUEST),
    TEAM_NOT_FOUND(400,"Team not found" ,HttpStatus.BAD_REQUEST ),
    ROLE_NOT_FOUND(400,"Role not found" ,HttpStatus.BAD_REQUEST ),
    USER_NOT_FOUND(400,"User not found",HttpStatus.BAD_REQUEST),
    USERNAME_DOES_NOT_EXIST(400,"Username does not exist",HttpStatus.BAD_REQUEST),
    INVALID_CREDENTIALS(400, "Password is incorrect",HttpStatus.BAD_REQUEST),
    SUPER_ADMIN_ROLE_NOT_FOUND(400, "Super admin role not found", HttpStatus.BAD_REQUEST),
    ROLE_NOT_ALLOWED(403,"Role not allowed" ,HttpStatus.FORBIDDEN),
    ONLY_LETTER(400,"First name: only letters" ,HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(400,"Username: Unique, character a-z, number 0-9, min length 3, max length 30" ,HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(400,"Password: at least 8 characters, including uppercase, lowercase, numbers, and special characters" ,HttpStatus.BAD_REQUEST),
    INVALID_BIRTH_YEAR(400,"Birth year must be greater than 1900" ,HttpStatus.BAD_REQUEST),
    CONFIRM_PASSWORD_REQUIRED(400, "Confirm password is required", HttpStatus.BAD_REQUEST),
    PASSWORD_CONFIRM_NOT_MATCH(400, "Confirm password does not match", HttpStatus.BAD_REQUEST),
    PASSWORD_REQUIRED(400, "Password is required", HttpStatus.BAD_REQUEST),
    COMPANY_CODE_REQUIRED(400, "Company code is required", HttpStatus.BAD_REQUEST),
    COMPANY_NAME_REQUIRED(400, "Company name is required", HttpStatus.BAD_REQUEST),
    CONTACT_NAME_REQUIRED(400, "Contact name is required", HttpStatus.BAD_REQUEST),
    MOBILE_PHONE_INVALID(400, "Mobile phone is invalid", HttpStatus.BAD_REQUEST),
    CODE_COMPANY_EXISTS(400, "Company code already exists", HttpStatus.BAD_REQUEST),
    INVALID_DOB(400, "Date of birth is invalid", HttpStatus.BAD_REQUEST),
    USER_INACTIVE(400, "User is inactive", HttpStatus.BAD_REQUEST),
    ROLE_ID_CANNOT_BE_NULL(400, "Role ID cannot be null", HttpStatus.BAD_REQUEST),
    PERMISSION_NOT_FOUND(400,"Permission not found" ,HttpStatus.BAD_REQUEST ),
    ROLE_ALREADY_EXISTS(400,"Role already exits" ,HttpStatus.BAD_REQUEST ),
    INVALID_INPUT(400,"Invalid input" ,HttpStatus.BAD_REQUEST ),
    UI_CONFIG_NOT_FOUND(400, "UI configuration not found", HttpStatus.BAD_REQUEST),
    SETTING_NOT_FOUND(400, "Setting not found", HttpStatus.BAD_REQUEST);

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
