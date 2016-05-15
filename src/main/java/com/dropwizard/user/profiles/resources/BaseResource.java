package com.dropwizard.user.profiles.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.dropwizard.user.profiles.core.BaseDomain;
import com.dropwizard.user.profiles.exception.UserNotFoundException;


public interface BaseResource <T extends BaseDomain> {

    @GET
	@Path("/{id}")
	public T retrieveByUserId( @PathParam("id") Integer id) throws UserNotFoundException;
       
}
