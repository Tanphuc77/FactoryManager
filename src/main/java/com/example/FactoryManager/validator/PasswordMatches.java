package com.example.FactoryManager.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
    String message() default "PASSWORD_CONFIRM_NOT_MATCH"; // dùng key này để map sang ErrorCode
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

