package ar.com.trimatec.copre.entities;

import java.util.Set;

public class Requirement {

	private Integer id;
	private Set<Item> items;
	private Participant participant;
	private Copre copre;
	private WorkflowNode currentWorkflowNode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Copre getCopre() {
		return copre;
	}

	public void setCopre(Copre copre) {
		this.copre = copre;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public WorkflowNode getCurrentWorkflowNode() {
		return currentWorkflowNode;
	}

	public void setCurrentWorkflowNode(WorkflowNode currentWorkflowNode) {
		this.currentWorkflowNode = currentWorkflowNode;
	}

}
