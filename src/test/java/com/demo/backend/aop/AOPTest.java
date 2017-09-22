package com.demo.backend.aop;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AOPTest {

	@Inject
	private AOPedObject test;


	@Test
	public void aop() {
		assertThat(test.doit()).isTrue();

	}

}
