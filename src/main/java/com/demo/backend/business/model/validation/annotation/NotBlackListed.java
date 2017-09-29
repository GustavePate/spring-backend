package com.demo.backend.business.model.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = NotBlackListedValidator.class)
public @interface NotBlackListed {

	String action() default "block";

	String message() default "user is blacklisted";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
