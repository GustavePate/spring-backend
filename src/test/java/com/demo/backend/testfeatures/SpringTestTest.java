package com.demo.backend.testfeatures;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.backend.testfeatures.conf.SpecificConfiguration;
import com.demo.backend.testfeatures.object.ITestObject;

@RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @ActiveProfiles("ic")
@TestPropertySource(properties = { "timezone = GMT", "port: 4242" })
@ContextConfiguration(classes = SpecificConfiguration.class)
public class SpringTestTest {

	private final static Logger log = LoggerFactory.getLogger(SpringTestTest.class);

	  /*
     * Chargement conf de test
     * Forcage de configuration
     * Forcage de properties
     * 
     */

	@Value("${timezone}")
	private String timezone;

	private String timezone2;

	@Inject
	private ITestObject impl;


	@Test
	public void testSpecificConf() {
		log.info("impl {}", impl.doit());
		assertThat(impl.doit()).isEqualToIgnoringCase("specific");
		assertThat(timezone).isEqualToIgnoringCase("GMT");
	}



}
