package com.demo.backend.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	private final static Logger log = LoggerFactory.getLogger(Receiver.class);

	public static int counter = 0;

	@EventListener
	@Order(2)
	public void processEvent(TestEvent event) throws InterruptedException {
		log.info("receiver1: " + event.code);
		Thread.sleep(1000);
		counter++;
	}

	@EventListener
	@Order(1)
	public void processEvent2(TestEvent event) throws InterruptedException {
		log.info("receiver2: " + event.code);
		Thread.sleep(2000);
		counter++;
	}

	@Async
	@EventListener
	public void processAsyncEvent(TestAsyncEvent event) throws InterruptedException {
		log.info("async receiver1: " + event.code);
		Thread.sleep(1000);
		counter++;
	}

	@Async
	@EventListener
	public void processAsyncEvent2(TestAsyncEvent event) throws InterruptedException {
		log.info("async receiver2: " + event.code);
		Thread.sleep(1000);
		counter++;
	}


}
