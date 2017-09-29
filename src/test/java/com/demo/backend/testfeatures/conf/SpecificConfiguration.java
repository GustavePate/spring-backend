package com.demo.backend.testfeatures.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.backend.testfeatures.object.ITestObject;
import com.demo.backend.testfeatures.object.TestObjectSpecific4Test;

@Configuration
public class SpecificConfiguration {

	@Bean
	ITestObject getObj() {
		return new TestObjectSpecific4Test();
	}

}
