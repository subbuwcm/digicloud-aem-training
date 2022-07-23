package com.digicloud.aem.core.models.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ExporterConstants;
import com.digicloud.aem.core.models.SlingModeldemoInterface;
import com.digicloud.aem.core.models.User;

@Model(adaptables = Resource.class, adapters = SlingModeldemoInterface.class, resourceType = "digicloud-training/components/sling-model-demo",defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SlingModeldemoInterfaceImpl implements SlingModeldemoInterface  {

	@ValueMapValue @Named("jcr:title")
	private String title;
	
	@ValueMapValue @Optional
	private String description;
	
	@ValueMapValue
	@Named("fileReference")
	private String imagePath;
	
	@ValueMapValue
	private String dropwdown;
		
	@Inject
    private List<User> users;
	
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getImagePath() {
		return imagePath;
	}

	@Override
	public String getDropwdown() {
		return dropwdown;
	}

	@Override
	public List<User> getUsers() {
		return users;
	}
	
}
