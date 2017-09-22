package com.demo.backend.business;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DIPlusProfile {

	private final static Logger log = LoggerFactory.getLogger(DIPlusProfile.class);

	@Inject
	@Named("dao")
	String dao;

	@Inject
	@Named("ds")
	String ds;

	DIPlusProfile() {

	}

	public void doIt() {

		log.info("dao: {} ds: {}", dao, ds);

	}

}
