package com.demo.backend.api.rest.jersey;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.backend.api.rest.springmvc.model.HelloResponse;
import com.demo.backend.business.DIPlusProfile;
import com.demo.backend.business.model.exceptions.InvalidInputException;
import com.demo.backend.business.model.validation.HelloName;

@Component
@Path("/hello")
public class HelloJersey {

	private final static Logger log = LoggerFactory.getLogger(HelloJersey.class);

	@Inject
	DIPlusProfile dpp;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public HelloResponse getAllBooks() {
		return new HelloResponse("default");
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}")
	public HelloResponse getBook(@PathParam("name") String name) {
		log.info("hello {}", name);
		dpp.doIt();
		return new HelloResponse(name);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/validate/annotation")
	public Response annotationBasedValidation(@Valid HelloName name) {

		log.info(name.getName());
		return Response.ok().build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/validate/manually")
	public Response manualValidation(HelloName name) throws InvalidInputException {

		/* Prefer the annotation based validation !!! */

		// Manual validation
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<HelloName>> violations = validator.validate(name);

		// Tailor made return message
		InvalidInputException invalid = new InvalidInputException();
		violations.forEach((v) -> {
			log.info("{} for value: {}", v.getMessage(), v.getInvalidValue());
			invalid.addMsg(String.format("for %s = %s: %s", v.getPropertyPath(), v.getInvalidValue(), v.getMessage()));
		});
		if (violations.size() > 0) {
			throw invalid;
		}

		return Response.ok().build();

	}

}