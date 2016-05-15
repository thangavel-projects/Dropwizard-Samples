package com.dropwizard.user.profiles.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class BadRequestException extends WebApplicationException {

	private static final long serialVersionUID = 8988397869989526402L;

	public BadRequestException(Status status) {
		super(Response.status(Response.Status.BAD_REQUEST).build());
	}
	
}
