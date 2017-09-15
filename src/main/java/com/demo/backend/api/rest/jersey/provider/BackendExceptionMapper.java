package com.demo.backend.api.rest.jersey.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.demo.backend.others.BackEndException;


@Provider
public class BackendExceptionMapper implements ExceptionMapper<BackEndException> {

	public Response toResponse(BackEndException exception) {
		return Response.status(501).build();
	}

}

