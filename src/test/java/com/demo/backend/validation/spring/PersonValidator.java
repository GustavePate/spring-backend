package com.demo.backend.validation.spring;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

	/**
	 * This Validator validates *just* Person instances
	 */


	public boolean supports(Class clazz) {
		return Person.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors e) {
		// ValidationUtils.rejectIfEmpty(e, "firstName", "name.empty");

        Person p = (Person) obj;
        if (p.getChildNumber() < 0) {
			e.rejectValue("childNumber", "Code 24", "negativevalue");
		}

		if (p.getLastName().length() < 2) {
			e.rejectValue("lastName", "Code 25", "too.short");
        }

    }
}


