package org.appsec.securityRAT.web.rest.dto;

import java.util.HashSet;
import java.util.Set;

import org.appsec.securityRAT.domain.OptColumnContent;
import org.appsec.securityRAT.domain.RequirementSkeleton;
import org.appsec.securityRAT.domain.TagInstance;
import org.appsec.securityRAT.domain.CollectionInstance;

public class FERequirementDTO {

	private Long id;

	private String shortName;

	private String universalId;

	private String description;

	private Integer showOrder;

	private Set<FEOptionColumnContentDTO> optionColumnContents;

	private Set<Long> tagInstanceIds;

	private Set<FECollectionInstanceDTO> collectionInstances;

	public FERequirementDTO(){
	}

	public FERequirementDTO(RequirementSkeleton skeleton) {
		this.id = skeleton.getId();
		this.shortName = skeleton.getShortName();
		this.universalId = skeleton.getUniversalId();
		this.description = skeleton.getDescription();
		this.showOrder = skeleton.getShowOrder();

		this.optionColumnContents = new HashSet<FEOptionColumnContentDTO>();
		Set<OptColumnContent> optColumnContentsForSkeleton = skeleton.getOptColumnContents();
		for (OptColumnContent optColumnContent : optColumnContentsForSkeleton) {
			this.optionColumnContents.add(new FEOptionColumnContentDTO(optColumnContent));
		}

		this.tagInstanceIds = new HashSet<Long>();
		Set<TagInstance> tagInstances = skeleton.getTagInstances();
		for (TagInstance tagInstance : tagInstances) {
			this.tagInstanceIds.add(tagInstance.getId());
		}

		this.collectionInstances = new HashSet<FECollectionInstanceDTO>();
		Set<CollectionInstance> collectionInstanceForSkeleton = skeleton.getCollectionInstances();
		for (CollectionInstance collectionInstance : collectionInstanceForSkeleton) {
			this.collectionInstances.add(new FECollectionInstanceDTO(collectionInstance));
		}
	}

	public Long getId() {
		return id;
	}

	public String getShortName() {
		return shortName;
	}

	public String getUniversalId() {
		return universalId;
	}

	public String getDescription() {
		return description;
	}

	public Integer getShowOrder() {
		return showOrder;
	}

	public Set<FEOptionColumnContentDTO> getOptionColumnContents() {
		return optionColumnContents;
	}

	public Set<Long> getTagInstanceIds() {
		return tagInstanceIds;
	}

        public Set<FECollectionInstanceDTO> getCollectionInstances() {
                return collectionInstances;
        }

}
