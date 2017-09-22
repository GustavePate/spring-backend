package com.demo.backend.others.springguts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class Guts {

	private final static Logger log = LoggerFactory.getLogger(Guts.class);

	@Inject
	public BeanFactory bf;

	@Inject
	public ApplicationContext ac;

	@Inject
	public Environment env;
	
	@Inject
	public ResourceLoader loader;

	@Inject
	public ApplicationEventPublisher publisher;

	@Inject
	public MessageSource ms;

	@PostConstruct
	public void construction() {
		log.info("post construct");
	}

	@PreDestroy
	public void destruction() {
		log.info("destroy");
	}

	@Inject
	public Guts() {

	}

}
