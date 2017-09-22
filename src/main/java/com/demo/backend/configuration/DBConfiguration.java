package com.demo.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DBConfiguration {

	@Bean("ds")
	@Profile("dev")
	public String dataSourceDev() {
		return "DEV";
	}

	@Bean("ds")
	@Profile("prd")
	public String dataSourcePrd() {
		return "PRD";
	}

	@Bean("ds")
	public String dataSourceRec() {
		return "REC";
	}

}
