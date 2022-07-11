package com.digicloud.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class Tile {
	
	@ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
	private String heading;
	
	@ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
	private String des;
	
	
	@ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
	private String fileReference;
	
	public String getHeading() {
		return heading;
	}
	public String getDes() {
		return des;
	}
	public String getFileReference() {
		return fileReference;
	}

}
