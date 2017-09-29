package com.demo.backend.guts;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.backend.di.YoupiContainer;
import com.demo.backend.others.springguts.Guts;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("unit")
public class GutsTest {

	private final static Logger log = LoggerFactory.getLogger(GutsTest.class);

	@Inject
	private Guts guts;

	@Inject
	private YoupiContainer youp;

	@Test
	public void accessSpringInternals() {

		assertThat(guts.ac).isNotNull();
		assertThat(guts.bf).isNotNull();
		assertThat(guts.env).isNotNull();
		assertThat(guts.loader).isNotNull();
		assertThat(guts.ms).isNotNull();
		assertThat(guts.publisher).isNotNull();

	}

}
