package ar.com.trimatec.copre.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ar.com.trimatec.copre.entities.Bid;
import ar.com.trimatec.copre.entities.Copre;
import ar.com.trimatec.copre.entities.Participant;
import ar.com.trimatec.copre.entities.Requirement;
import ar.com.trimatec.copre.misc.RequirementStateEnum;
import ar.com.trimatec.copre.services.bi.BidService;

public class BidServiceImpl extends BaseServiceImpl implements BidService {

	@Override
	public Bid addBid(Integer requirementId, Integer participantId,
			String comment, BigDecimal price) {
		Copre copre = getCopreRepository().findCopre();
		Requirement requirement = getRequirementRepository().findRequirement(
				requirementId);
		Participant participant = getParticipantRepository().findParticipant(
				participantId);
		return copre.addBid(requirement, participant, comment, price);
	}

	@Override
	public List<Bid> loadFilteredBids() {
		List<Bid> bids = getBidRepository().listAll();
		return filterBids(bids);
	}
	
	private List<Bid> filterBids(List<Bid> bids){
		Integer reqNodeDescId;
		List<Bid> filteredBids = new ArrayList<Bid>();
		for (Bid bid : bids) {
			reqNodeDescId = bid.getRequirement().getCurrentWorkflowNode()
					.getNodeDescription().getId();
			if (reqNodeDescId.equals(RequirementStateEnum.DISPLAYED.getId())
					|| reqNodeDescId.equals(RequirementStateEnum.BIDDED.getId())){
				filteredBids.add(bid);
			}
		}
		return filteredBids;
	}

	@Override
	public Bid update(Integer bidId, BigDecimal price, String comment,
			Boolean accepted) {
		Copre copre = getCopreRepository().findCopre();
		return copre.updateBid(bidId, price, comment, accepted);
	}

}
