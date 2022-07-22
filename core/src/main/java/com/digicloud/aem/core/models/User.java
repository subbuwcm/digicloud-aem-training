package com.digicloud.aem.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class User {
	
	@Inject
    @Named("log")
    private Logger logger;
	
	@ValueMapValue
	public String firstName;
	
	
	@ValueMapValue
	public String lastName;
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	@PostConstruct
	protected void init() {
		
	}

}
