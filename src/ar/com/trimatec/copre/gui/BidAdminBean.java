package ar.com.trimatec.copre.gui;

import java.io.IOException;
import java.util.List;

import javax.faces.event.ActionEvent;

import ar.com.trimatec.copre.entities.Bid;
import ar.com.trimatec.copre.entities.Item;
import ar.com.trimatec.copre.entities.Requirement;
import ar.com.trimatec.copre.misc.RequirementStateEnum;
import ar.com.trimatec.copre.model.exceptions.EmptyBidListException;
import ar.com.trimatec.copre.utils.Constants;

public class BidAdminBean extends CommonBean {

	private Bid bid;
	private int bidListIndex;
	private List<Item> items;
	private List<Bid> bids;

	public Bid getBid() throws EmptyBidListException, IOException {
		if (bids == null || bids.size() < 1) {
			bids = loadBids();
			if (bids.size() == 0) {
				redirectTo("/pages/" + Constants.NO_BIDS
						+ Constants.EXT_JSF);
				return null;
			}
			bidListIndex = 0;
		}
		bid = bids.get(bidListIndex);
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public List<Item> getItems() throws EmptyBidListException {
		if (bids.size() > 0 && items == null) {
			items = loadItems();
		}
		return items;
	}

	public int getIndex() {
		return bidListIndex + 1;
	}

	private List<Bid> loadBids() {
		bids = getBidService().loadFilteredBids();
		return bids;
	}

	private List<Item> loadItems() throws EmptyBidListException {
		return getRequirementService().listItemsByRequirementId(
				bid.getRequirement().getId());
	}

	public void previous(ActionEvent event) throws EmptyBidListException {
		if (bidListIndex > 0) {
			bid = bids.get(--bidListIndex);
			items = loadItems();
		}
	}

	public void next(ActionEvent event) throws EmptyBidListException {
		if (bidListIndex < bids.size() - 1) {
			bid = bids.get(++bidListIndex);
			items = loadItems();
		}
	}

	public void confirm(ActionEvent event) {
		bid = getBidService().update(bid.getId(), bid.getPrice(),
				bid.getComment(), Boolean.TRUE);
		Requirement requirement = updateBidStatus(bid);
		bid.setRequirement(requirement);
		bids = null;
	}

	private Requirement updateBidStatus(Bid bid) {
		return getRequirementService().updateRequirementWorkflowNode(
				bid.getRequirement(), RequirementStateEnum.ACCEPTED);
	}

	public int getBidListSize() {
		return bids.size();
	}

	public void refresh(ActionEvent event) {
		bids = null;
	}
	
	public void load(ActionEvent event) throws IOException{
		bids = loadBids();
		if (bids.size() == 0) {
			redirectTo("/pages/" + Constants.NO_BIDS
					+ Constants.EXT_JSF);
		}
	}

}