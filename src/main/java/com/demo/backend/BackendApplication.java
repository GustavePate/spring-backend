package com.demo.backend;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.backend.others.aspect.DemoAspect;

@SpringBootApplication
@EnableAspectJAutoProxy
@Controller
public class BackendApplication extends SpringBootServletInitializer {

	@RequestMapping("/")
	String homepage(Map<String, Object> model) {
		// return homepage template name
		// see -> resources -> templates
		model.put("server_side", "super value");

		return "index";
	}

	// test 5xx errors
	@RequestMapping("/500")
	public String ServiceUnavailable() {
		throw new RuntimeException("Error tester");
	}


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public DemoAspect aspect() {
		return new DemoAspect();
	}

}
