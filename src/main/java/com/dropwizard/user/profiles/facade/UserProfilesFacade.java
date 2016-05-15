package com.dropwizard.user.profiles.facade;

import javax.inject.Inject;

import com.dropwizard.user.profiles.core.UserDetails;
import com.dropwizard.user.profiles.db.GenericDAO;
import com.google.common.base.Optional;

public class UserProfilesFacade implements BaseFacade<UserDetails>{

	private GenericDAO<UserDetails> dao;
	
	@Inject
	public UserProfilesFacade(GenericDAO<UserDetails> dao) {
		this.dao = dao;
	}
	
	@Override
	public Optional<UserDetails> findById(Integer id) {
		System.out.println("The DAO :"+dao);
		System.out.println("The ID :"+id);
        return dao.findById(id);
    }
}
