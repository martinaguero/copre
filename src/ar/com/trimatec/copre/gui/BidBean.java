package ar.com.trimatec.copre.gui;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.event.ActionEvent;

import ar.com.trimatec.copre.entities.Bid;
import ar.com.trimatec.copre.entities.Item;
import ar.com.trimatec.copre.entities.Requirement;
import ar.com.trimatec.copre.misc.RequirementStateEnum;
import ar.com.trimatec.copre.utils.Constants;

public class BidBean extends CommonBean {

	private Requirement requirement;
	private List<Item> items;
	private int reqListIndex;
	private BigDecimal price;
	private String comment;
	private Bid bid;
	private List<Requirement> requirements;

	public Requirement getRequirement() throws IOException {
		if (requirements == null || requirements.size() < 1) {
			requirements = loadRequirements();
			if (requirements.size() == 0) {
				redirectTo("/pages/" + Constants.NO_REQUIREMENT
						+ Constants.EXT_JSF);
				return null;
			}
			reqListIndex = 0;
			requirement = requirements.get(reqListIndex);
		}
		requirement = updateRequirementStatus(requirement);
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Item> getItems() {
		if (requirements.size()>0 && items == null) {
			items = loadItems();
		}
		return items;
	}

	public int getIndex() {
		return reqListIndex + 1;
	}

	private List<Requirement> loadRequirements() {
		requirements = getRequirementService().loadFilteredRequirements();
		return requirements;
	}

	private List<Item> loadItems() {
		return getRequirementService().listItemsByRequirementId(
				requirement.getId());
	}

	public void previous(ActionEvent event) {
		if (reqListIndex > 0) {
			requirements.set(reqListIndex, requirement);
			requirement = requirements.get(--reqListIndex);
			items = loadItems();
		}
	}

	public void next(ActionEvent event) {
		if (reqListIndex < requirements.size() - 1) {
			requirements.set(reqListIndex, requirement);
			requirement = requirements.get(++reqListIndex);
			items = loadItems();
		}
	}

	private Requirement updateRequirementStatus(Requirement requirement) {
		if (requirement.getCurrentWorkflowNode().getNodeDescription().getId()
				.equals(RequirementStateEnum.NEW.getId())) {
			requirement = getRequirementService()
					.updateRequirementWorkflowNode(requirement,
							RequirementStateEnum.DISPLAYED);
		}
		return requirement;
	}

	public void saveBid(ActionEvent event) {
		bid = getBidService().addBid(requirement.getId(), 107, getComment(),
				price);
		if (bid != null) {
			requirement = getRequirementService()
					.updateRequirementWorkflowNode(requirement,
							RequirementStateEnum.BIDDED);
		}
		requirements = null;
	}

	public int getReqListSize() {
		return requirements.size();
	}

	public void refresh(ActionEvent event) {
		requirements = null;
	}

}