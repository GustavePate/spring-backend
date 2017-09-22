package com.demo.backend.event;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("unit")
public class EventTest {


	private final static Logger log = LoggerFactory.getLogger(EventTest.class);

	@Inject
	private ApplicationEventPublisher publisher;


	@Test
	public void sendEvent() {

		TestEvent event = new TestEvent();
		event.code = "yop";
		long millis = System.currentTimeMillis();
		publisher.publishEvent(event);
		long duration = System.currentTimeMillis() - millis;

		assertThat(duration).isBetween(3000L, 3100L);
		assertThat(Receiver.counter).isGreaterThan(0);
		log.info("duration: {}ms", duration);

	}

	@Test
	public void sendAsyncEvent() throws InterruptedException {

		TestEvent event1 = new TestEvent();
		event1.code = "yop";
		Receiver.counter = 0;
		TestAsyncEvent event = new TestAsyncEvent(event1);
		event.code = "async";

		long millis = System.currentTimeMillis();
		publisher.publishEvent(event);
		long duration = System.currentTimeMillis() - millis;

		assertThat(duration).isLessThan(50L);

		duration = System.currentTimeMillis() - millis;
		log.info("send duration: {}ms", duration);

		Thread.sleep(1500);
		assertThat(Receiver.counter).isGreaterThan(0);

		duration = System.currentTimeMillis() - millis;
		log.info("total duration: {}ms", duration);

	}

}
