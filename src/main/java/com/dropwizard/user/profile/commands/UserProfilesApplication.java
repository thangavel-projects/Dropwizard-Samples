package com.dropwizard.user.profile.commands;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dropwizard.user.profiles.core.UserDetails;
import com.dropwizard.user.profiles.dao.UserDetailsDAO;
import com.dropwizard.user.profiles.db.GenericDAO;
import com.dropwizard.user.profiles.facade.BaseFacade;
import com.dropwizard.user.profiles.facade.UserProfilesFacade;
import com.dropwizard.user.profiles.resources.UserDetailsResource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class UserProfilesApplication extends Application<UserProfilesConfiguration> {
	
	 private final Logger logger = LoggerFactory.getLogger(UserProfilesApplication.class);
	
	  private final HibernateBundle<UserProfilesConfiguration> hibernateBundle;

	  public UserProfilesApplication() {

		  this.hibernateBundle= new HibernateBundle<UserProfilesConfiguration>(
	          UserDetails.class) {
	          @Override
	          public DataSourceFactory getDataSourceFactory(
	        		  UserProfilesConfiguration configuration) {
	              return configuration.getDataSourceFactory();
	
	          }
	          
	      };
	  }

    @Override
	public void initialize(Bootstrap<UserProfilesConfiguration> bootstrap) {
    	bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
    	
    	bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<UserProfilesConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(UserProfilesConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new ViewBundle<UserProfilesConfiguration>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(UserProfilesConfiguration configuration) {
                return configuration.getViewRendererConfiguration();
            }
        });

	}
  
	@Override
	public void run(UserProfilesConfiguration configuration, Environment environment) throws Exception {
		
        final GenericDAO<UserDetails> dao = new UserDetailsDAO(this.hibernateBundle.getSessionFactory());
        final BaseFacade<UserDetails> userProfileFacade =  new UserProfilesFacade(dao);
        
        environment.jersey().register(
            new UserDetailsResource(userProfileFacade, configuration)
        );
      
	}

	public static void main(String[] args) throws Exception {
	       new UserProfilesApplication().run(args);
	}

}