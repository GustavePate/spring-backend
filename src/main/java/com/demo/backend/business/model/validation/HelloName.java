package com.demo.backend.business.model.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.demo.backend.business.model.validation.annotation.NotBlackListed;

@Component
public class HelloName {

	@Size(min = 2, message = "name should be longer")
	@NotBlackListed(action = "warn", message = "user is blacklisted")
	private String name;

	@NotNull(message = "name type can't be null")
	private NameType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NameType getType() {
		return type;
	}

	public void setType(NameType type) {
		this.type = type;
	}



}
