package ar.com.trimatec.copre.services.bi;

import java.math.BigDecimal;
import java.util.List;

import ar.com.trimatec.copre.entities.Bid;

public interface BidService {

	public Bid addBid(Integer requirementId, Integer participantId,
			String comment, BigDecimal price);

	public List<Bid> loadFilteredBids();

	public Bid update(Integer bidId, BigDecimal price, String comment,
			Boolean accepted);

}
