package com.demo.backend.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.TestConfiguration;

import com.demo.backend.guts.GutsTest;

@TestConfiguration
public class TestConf {

	private final static Logger log = LoggerFactory.getLogger(GutsTest.class);

	/*
	 * @Bean
	 * 
	 * @Scope("prototype") public YoupiContainer prototypeInstance(InjectionPoint
	 * injectionPoint) { log.info(injectionPoint.getMember().getName());
	 * log.info(injectionPoint.getClass().getCanonicalName());
	 * log.info(injectionPoint.getField().getDeclaringClass().getCanonicalName());
	 * return new YoupiContainer(); }
	 */

}
