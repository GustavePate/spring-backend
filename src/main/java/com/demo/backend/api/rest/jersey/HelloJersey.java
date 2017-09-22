package com.demo.backend.api.rest.jersey;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.backend.api.rest.springmvc.model.HelloResponse;
import com.demo.backend.business.DIPlusProfile;

@Component
@Path("/hello")
public class HelloJersey {

	private final static Logger logger = LoggerFactory.getLogger(HelloJersey.class);

	@Inject
	DIPlusProfile dpp;

	@GET
	@Produces("application/json")
	public HelloResponse getAllBooks() {
		return new HelloResponse("default");
	}

	@GET
	@Produces("application/json")
	@Path("/{name}")
	public HelloResponse getBook(@PathParam("name") String name) {
		logger.info("hello {}", name);
		dpp.doIt();
		return new HelloResponse(name);
	}

}