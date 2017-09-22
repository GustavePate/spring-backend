package com.demo.backend.event;

import org.springframework.context.ApplicationEvent;

public class TestAsyncEvent extends ApplicationEvent {

	public String code = "ORDER1";

	public TestAsyncEvent(Object source) {
		super(source);
	}

}
