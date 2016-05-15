package com.dropwizard.user.profiles.facade;

import com.dropwizard.user.profiles.core.BaseDomain;
import com.google.common.base.Optional;

public interface BaseFacade <T extends BaseDomain> {

    public Optional<T> findById(Integer id);

}
