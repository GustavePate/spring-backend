package com.demo.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.demo.backend.di.Youpi;
import com.demo.backend.guts.GutsTest;

@TestConfiguration
public class TestConf {

	private final static Logger log = LoggerFactory.getLogger(GutsTest.class);

	@Bean
	@Scope("prototype")
	public Youpi prototypeInstance(InjectionPoint injectionPoint) {
		log.info(injectionPoint.getMember().getName());
		log.info(injectionPoint.getClass().getCanonicalName());
		log.info(injectionPoint.getField().getDeclaringClass().getCanonicalName());
		return new Youpi();
	}

}
