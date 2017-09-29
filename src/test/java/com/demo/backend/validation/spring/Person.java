package com.demo.backend.validation.spring;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Person {

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String adress;

	@NotNull
	private String postalCode;

	@NotNull
	@Min(0)
	private int childNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getChildNumber() {
		return childNumber;
	}

	public void setChildNumber(int childNumber) {
		this.childNumber = childNumber;
	}

}
