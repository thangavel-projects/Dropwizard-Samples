package com.dropwizard.user.profiles.dao;

import org.hibernate.SessionFactory;

import com.dropwizard.user.profiles.core.UserDetails;
import com.dropwizard.user.profiles.db.GenericDAO;
import com.google.common.base.Optional;

public class UserDetailsDAO extends BaseDAO<UserDetails> implements GenericDAO<UserDetails>{

	public UserDetailsDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Optional<UserDetails> findById(Integer id) {
		 return Optional.fromNullable(get(id));
	}
}
