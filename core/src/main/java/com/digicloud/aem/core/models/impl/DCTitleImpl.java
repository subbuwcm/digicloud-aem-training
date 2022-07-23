package com.digicloud.aem.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.commons.link.Link;
import com.adobe.cq.wcm.core.components.models.Title;
import com.digicloud.aem.core.models.DCTitle;

@Model(adaptables = {
		SlingHttpServletRequest.class }, adapters = DCTitle.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = "digicloud-training/components/title")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class DCTitleImpl implements DCTitle {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Self
	private SlingHttpServletRequest request;

	@Self
	@Via(type = ResourceSuperType.class)
	private Title deligate;

	@ValueMapValue
	@Via("resource")
	private String subHeading;
	
	String type;

	@PostConstruct
	protected void initModel() {
		logger.info("-=-==-=" + deligate + "===> Subheading : " + subHeading);
		if(deligate.getType().equalsIgnoreCase("h2")) {
			type = "h1";
			subHeading = "added in sling modal"+subHeading;
		}
	}

	@Override
	public String getSubHeading() {
		return subHeading;
	}

	@Override
	public String getText() {
		return deligate.getText();
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public Link getLink() {
		return deligate.getLink();
	}

	@Override
	public boolean isLinkDisabled() {
		return deligate.isLinkDisabled();
	}

}
