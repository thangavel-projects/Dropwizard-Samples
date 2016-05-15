package com.dropwizard.user.profiles.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dropwizard.user.profiles.commands.UserProfilesConfiguration;
import com.dropwizard.user.profiles.core.UserDetails;
import com.dropwizard.user.profiles.exception.UserNotFoundException;
import com.dropwizard.user.profiles.facade.BaseFacade;
import com.google.common.base.Optional;

import io.dropwizard.hibernate.UnitOfWork;

@Path("/User_Profiles")
@Produces(MediaType.APPLICATION_JSON)
public class UserDetailsResource implements BaseResource<UserDetails>{

	private final BaseFacade<UserDetails> facade;

    @Inject
    public UserDetailsResource(BaseFacade<UserDetails> facade, UserProfilesConfiguration config)
        throws java.net.URISyntaxException {
        this.facade = facade;
    }

    @GET
	@Path("/{id}")
    @UnitOfWork
    public UserDetails retrieveByUserId(@PathParam("id") Integer id) throws UserNotFoundException {
    	Optional<UserDetails> op = facade.findById(id);
        if (!op.isPresent()) {
			throw new UserNotFoundException();
		}
		return op.get();
    }
}
