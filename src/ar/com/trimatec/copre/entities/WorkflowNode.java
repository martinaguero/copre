package ar.com.trimatec.copre.entities;

import java.util.Date;

public class WorkflowNode {

	private Integer id;
	private Date initDate;
	private Date endDate;
	private WorkflowNodeDescription nodeDescription;
	private Requirement requirement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public WorkflowNodeDescription getNodeDescription() {
		return nodeDescription;
	}

	public void setNodeDescription(WorkflowNodeDescription nodeDescription) {
		this.nodeDescription = nodeDescription;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

}