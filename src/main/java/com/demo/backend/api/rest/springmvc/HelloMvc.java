package com.demo.backend.api.rest.springmvc;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.backend.api.rest.springmvc.model.HelloResponse;

@RestController
@RequestMapping("mvc")
public class HelloMvc {

	private final static Logger logger = LoggerFactory.getLogger(HelloMvc.class);

	public String hardCodedGreeting() {
		return "Hello world !";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String genericGreeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		logger.info("hardcoded");
		return hardCodedGreeting();
	}

	@RequestMapping(value = "/hello/{id}",
			method = RequestMethod.GET)
	public HelloResponse greeting(@PathVariable(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {

		HelloResponse res = new HelloResponse(name);

		try {
			logger.info("call to service hello");
			model.addAttribute("name", name);
			// res = res + " " + id + " !";
		} catch (Exception e) {
			logger.error("hello", e);
			// res = e.getMessage();
			throw e;
		}finally {
			return res;
		}

	}
}
