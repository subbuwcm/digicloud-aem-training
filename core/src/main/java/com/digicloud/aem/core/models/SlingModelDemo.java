package com.digicloud.aem.core.models;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = {Resource.class }, 
		resourceType  = "digicloud-training/components/sling-model-demo", 
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json")
public class SlingModelDemo {
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@ValueMapValue @Named("jcr:title")
	private String title;
	
	@ValueMapValue @Optional
	private String description;
	
	@ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
	@Named("fileReference")
	private String imagePath;
	
	@ValueMapValue
	private String dropwdown;
	
	private String testSlingModalget;
	
	@Inject
    private List<User> users;
	
	@PostConstruct
	protected void init() {
		logger.info("-=-=-=-=-="+users);
	}

	public String getTestSlingModalget() {
		return "hard coded value";
	}
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getDropwdown() {
		return dropwdown;
	}

	public List<User> getUsers() {
		return users;
	}
}
