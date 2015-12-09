package ar.com.trimatec.copre.entities;

public class WorkflowLinkDescription {

	private Integer id;
	private String title;
	private WorkflowNodeDescription initialNodeDescription;
	private WorkflowNodeDescription finalNodeDescription;
	private WorkflowDescription workflowDescription;

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

	public WorkflowNodeDescription getInitialNodeDescription() {
		return initialNodeDescription;
	}

	public void setInitialNodeDescription(
			WorkflowNodeDescription initialNodeDescription) {
		this.initialNodeDescription = initialNodeDescription;
	}

	public WorkflowNodeDescription getFinalNodeDescription() {
		return finalNodeDescription;
	}

	public void setFinalNodeDescription(
			WorkflowNodeDescription finalNodeDescription) {
		this.finalNodeDescription = finalNodeDescription;
	}

	public WorkflowDescription getWorkflowDescription() {
		return workflowDescription;
	}

	public void setWorkflowDescription(WorkflowDescription workflowDescription) {
		this.workflowDescription = workflowDescription;
	}

}
