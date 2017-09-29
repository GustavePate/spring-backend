package com.demo.backend.business.model.exceptions;

import java.util.ArrayList;
import java.util.List;

public class InvalidInputException extends Exception {

	private List<String> violations = new ArrayList<>();

	public InvalidInputException() {
		super();
	}

	public InvalidInputException(String message) {
		super(message);
	}

	public void addMsg(String message) {
		violations.add(message);
	}

	public List<String> getMessages() {
		return violations;
	}

}
