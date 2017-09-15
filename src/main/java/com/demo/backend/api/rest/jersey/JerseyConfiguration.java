package com.demo.backend.api.rest.jersey;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.demo.backend.api.rest.jersey.provider.BackendExceptionMapper;
import com.demo.backend.api.rest.jersey.provider.GenericExceptionMapper;

@Configuration
@ApplicationPath("api")
@Primary
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {

	}

	@PostConstruct
	public void setUp() {
		register(HelloJersey.class);
		register(GenericExceptionMapper.class);
		register(BackendExceptionMapper.class);
	}
}