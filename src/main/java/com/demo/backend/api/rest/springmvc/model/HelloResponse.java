package com.demo.backend.api.rest.springmvc.model;

public class HelloResponse {

	String name;
	long timestamp;

	public HelloResponse(String name) {
		this.name = name;
		this.timestamp = System.currentTimeMillis();
	}
	
	public long getId() {
		return this.timestamp;
	}

	public String getContent() {
		return this.name + " @ " + String.valueOf(this.timestamp);
	}

}
