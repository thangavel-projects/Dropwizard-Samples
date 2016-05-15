package com.dropwizard.user.profile.commands;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class UserProfilesConfiguration extends Configuration {
	
	private URI endpointUri = null;

	@NotNull
    private Map<String, Map<String, String>> viewRendererConfiguration = Collections.emptyMap();

	@NotNull
	@JsonProperty("endpoint")
	private String endpoint;

	@Valid
	@NotNull
	@JsonProperty("database")
	private DataSourceFactory database = new DataSourceFactory();

	public DataSourceFactory getDataSourceFactory() {
		return database;
	}

	public URI getEndpoint() throws java.net.URISyntaxException {
		if (null == this.endpointUri) {
			this.endpointUri = new URI(this.endpoint);
		}
		return this.endpointUri;
	}
	
	@JsonProperty("viewRendererConfiguration")
    public Map<String, Map<String, String>> getViewRendererConfiguration() {
        return viewRendererConfiguration;
    }

    @JsonProperty("viewRendererConfiguration")
    public void setViewRendererConfiguration(Map<String, Map<String, String>> viewRendererConfiguration) {
        ImmutableMap.Builder<String, Map<String, String>> builder = ImmutableMap.builder();
        for (Map.Entry<String, Map<String, String>> entry : viewRendererConfiguration.entrySet()) {
            builder.put(entry.getKey(), ImmutableMap.copyOf(entry.getValue()));
        }
        this.viewRendererConfiguration = builder.build();
    }
}
