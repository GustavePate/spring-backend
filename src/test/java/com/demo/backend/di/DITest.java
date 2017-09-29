package com.demo.backend.di;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("unit")
public class DITest {

	private final static Logger log = LoggerFactory.getLogger(DITest.class);

	@Inject
	YoupiContainer youpi;

	String ref = "";

	@Test
	public void simpleInstanciate() {
		assertThat(youpi).isNotNull();
		assertThat(youpi.getMessage()).isEqualTo("youpi");
	}

}
