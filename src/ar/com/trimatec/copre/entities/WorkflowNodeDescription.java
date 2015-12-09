package ar.com.trimatec.copre.entities;

import java.util.Set;

public class WorkflowNodeDescription {

	private Integer id;
	private String title;
	private Boolean isFinalNode;
	private Set<WorkflowLinkDescription> linkDescriptions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsFinalNode() {
		return isFinalNode;
	}

	public void setIsFinalNode(Boolean isFinalNode) {
		this.isFinalNode = isFinalNode;
	}

	public Set<WorkflowLinkDescription> getLinkDescriptions() {
		return linkDescriptions;
	}

	public void setLinkDescriptions(
			Set<WorkflowLinkDescription> linkDescriptions) {
		this.linkDescriptions = linkDescriptions;
	}

}
