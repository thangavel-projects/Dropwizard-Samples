package com.dropwizard.user.profiles.db;

import com.dropwizard.user.profiles.core.BaseDomain;
import com.google.common.base.Optional;


public interface GenericDAO <T  extends BaseDomain> {
    
    public Optional<T> findById(Integer id);

}
