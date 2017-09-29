package com.demo.backend.di;

import org.springframework.stereotype.Component;

@Component
public class YoupiContainer {

	TheMessage zemessage;

	public YoupiContainer(TheMessage zemessage) {
		this.zemessage = zemessage;
	}

	public String getMessage() {
		return zemessage.msg;
	}

}
