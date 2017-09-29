package com.demo.backend.business.model.validation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotBlackListedValidator implements ConstraintValidator<NotBlackListed, String> {

	private final static Logger log = LoggerFactory.getLogger(NotBlackListedValidator.class);

	private String action;

	@Override
	public void initialize(NotBlackListed constraintAnnotation) {
		this.action = constraintAnnotation.action();
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext arg1) {
		boolean res = true;

		if (username.equalsIgnoreCase("admin")) {
			if ("block".equalsIgnoreCase(action)) {
				log.info("user {} is blacklisted !", username);
				res = false;
			} else {
				log.warn("user {} is blacklisted !", username);

			}
		}
		return res;
	}

}
