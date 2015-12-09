package ar.com.trimatec.copre.entities;

import java.util.Set;

public class WorkflowDescription {

	private Integer id;
	private String title;
	private Set<WorkflowNodeDescription> nodeDescriptions;
	private Set<WorkflowLinkDescription> linkDescriptions;
	private WorkflowNodeDescription initialNodeDescription;

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

	public Set<WorkflowNodeDescription> getNodeDescriptions() {
		return nodeDescriptions;
	}

	public void setNodeDescriptions(
			Set<WorkflowNodeDescription> nodeDescriptions) {
		this.nodeDescriptions = nodeDescriptions;
	}

	public Set<WorkflowLinkDescription> getLinkDescriptions() {
		return linkDescriptions;
	}

	public void setLinkDescriptions(
			Set<WorkflowLinkDescription> linkDescriptions) {
		this.linkDescriptions = linkDescriptions;
	}

	public WorkflowNodeDescription getInitialNodeDescription() {
		return initialNodeDescription;
	}

	public void setInitialNodeDescription(
			WorkflowNodeDescription initialNodeDescription) {
		this.initialNodeDescription = initialNodeDescription;
	}

}
