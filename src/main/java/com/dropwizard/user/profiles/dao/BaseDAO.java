package com.dropwizard.user.profiles.dao;

import org.hibernate.SessionFactory;

import com.dropwizard.user.profiles.core.UserDetails;
import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;

public abstract class BaseDAO<T> extends AbstractDAO<T> {

	public BaseDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public abstract Optional<UserDetails> findById(Integer id);

}
