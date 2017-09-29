package com.demo.backend.api.rest.jersey.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.demo.backend.business.model.exceptions.InvalidInputException;


@Provider
public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException> {

	public Response toResponse(InvalidInputException exception) {

		/*
		 * String entity = ""; for (String msg : exception.getMessages()) { entity =
		 * entity + msg; }
		 */

		return Response.status(501).entity(exception.getMessages()).build();
	}

}

