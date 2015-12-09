package ar.com.trimatec.copre.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.com.trimatec.copre.model.exceptions.ParticipantCuitNotUniqueException;
import ar.com.trimatec.copre.repositories.RepositoryLocator;
import ar.com.trimatec.copre.repositories.bi.ParticipantRepositoryBI;

public class Copre {

	private int id;
	private Set<Participant> participants;
	private Set<Category> categories;
	private Set<Requirement> requirements;
	private Set<Bid> bids;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public Participant addParticipant(String companyName, String cuit,
			String address, String telephone, String email, String password,
			Set<Category> categories) throws ParticipantCuitNotUniqueException {
		Participant p = null;

		if (this.getParticipiantRepository().findByCuit(cuit) != null) {
			throw new ParticipantCuitNotUniqueException();
		} else {
			p = new Participant();
			p.setCompanyName(companyName);
			p.setCuit(cuit);
			p.setAddress(address);
			p.setTelephone(telephone);
			p.setEmail(email);
			p.setPassword(password);
			p.setCategories(categories);
			p.setCopre(this);
			if (participants == null) {
				participants = new HashSet();
			}
			participants.add(p);
		}
		return p;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Requirement> getRequirements() {
		return requirements;
	}

	public void setRequirements(Set<Requirement> requirements) {
		this.requirements = requirements;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	public void addCategory(Category category) {
		if (categories == null) {
			categories = new HashSet();
		}
	}

	private ParticipantRepositoryBI getParticipiantRepository() {
		return RepositoryLocator.getInstance().getParticipantRepository();
	}

	public Requirement addRequirement(List<Item> items,
			Participant participant,
			WorkflowNodeDescription initialWorkflowNodeDescription) {

		Requirement requirement = new Requirement();
		requirement.setItems(new HashSet(items));
		requirement.setParticipant(participant);
		WorkflowNode currentWorkflowNode = new WorkflowNode();
		currentWorkflowNode.setNodeDescription(initialWorkflowNodeDescription);
		currentWorkflowNode.setInitDate(new Date());
		currentWorkflowNode.setRequirement(requirement);
		requirement.setCurrentWorkflowNode(currentWorkflowNode);
		requirement.setCopre(this);
		requirements.add(requirement);
		return requirement;
	}

	public Requirement updateRequirementState(Requirement requirement) {
		for (Requirement req : requirements) {
			if (req.getId().equals(requirement.getId())) {
				WorkflowNode node = req.getCurrentWorkflowNode();
				node.setEndDate(new Date());
				req.setCurrentWorkflowNode(node);
				return req;
			}
		}
		return requirement;
	}

	public Requirement updateRequirementState(
			WorkflowNodeDescription nodeDescription, Requirement requirement) {
		for (Requirement req : requirements) {
			if (req.getId().equals(requirement.getId())) {
				WorkflowNode node = new WorkflowNode();
				node.setRequirement(requirement);
				node.setInitDate(new Date());
				node.setNodeDescription(nodeDescription);
				req.setCurrentWorkflowNode(node);
				return req;
			}
		}
		return requirement;
	}

	public Bid addBid(Requirement requirement, Participant participant,
			String comment, BigDecimal price) {

		Bid bid = new Bid();
		bid.setComment(comment);
		bid.setPrice(price);
		bid.setParticipant(participant);
		bid.setRequirement(requirement);
		bid.setCopre(this);
		bids.add(bid);
		return bid;
	}

	public Bid updateBid(Integer bidId, BigDecimal price, String comment,
			Boolean accepted) {
		for (Bid bid : bids) {
			if (bid.getId().equals(bidId)) {
				bid.setPrice(price);
				bid.setComment(comment);
				bid.setAccepted(accepted);
				return bid;
			}
		}
		return null;
	}

}
