package com.demo.backend.api.rest.jersey.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {


	public Response toResponse(Exception exception) {
		return Response.serverError().entity(exception.getMessage()).build();
	}

}