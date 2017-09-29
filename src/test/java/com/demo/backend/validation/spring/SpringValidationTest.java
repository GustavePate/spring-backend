package com.demo.backend.validation.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("unit")
public class SpringValidationTest {

	private final static Logger log = LoggerFactory.getLogger(SpringValidationTest.class);

	@Autowired
	private PersonValidator validator;

	@Test
	public void checkPersonInfo() {

		/*
		 * Exemple of full manual validation and validator
		 */
		
		Person p = new Person();
		p.setLastName("un super nom");
		p.setChildNumber(-1);

		// Full manual validation
		DataBinder binder = new DataBinder(p);
		binder.setValidator(validator);
		binder.validate();
		BindingResult results = binder.getBindingResult();
		log.info("nb error: {}", results.getErrorCount());
		results.getAllErrors().stream().forEach((ObjectError e) -> {
			log.info("{} {} {}", e.getCode(), e.getObjectName(), e.getDefaultMessage()); 
		});
		assertThat(results.getAllErrors()).hasSize(1);
		

	}


}
