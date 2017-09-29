package com.demo.backend.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AOPedObject {

	private final static Logger log = LoggerFactory.getLogger(AOPedObject.class);

	/* AOPed via a aspectj synthax */
	/* @see com/demo.backend.other.aspect.DemoAspect */
	public boolean doit() {
		log.info("doit !");
		return true;
	}

}
