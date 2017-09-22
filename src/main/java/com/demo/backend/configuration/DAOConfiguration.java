package com.demo.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DAOConfiguration {

	@Bean("dao")
	@Profile("!ic")
	public String dataSourceDefault() {
		return "NoMock";
	}

	@Bean("dao")
	public String dataSourceMock() {
		return "Mock";
	}

}
