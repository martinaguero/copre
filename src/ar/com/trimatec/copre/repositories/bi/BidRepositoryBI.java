package ar.com.trimatec.copre.repositories.bi;

import java.util.List;

import ar.com.trimatec.copre.entities.Bid;

public interface BidRepositoryBI extends CopreAbstractRepositoryBI {

	public Bid findBid(Integer id);
	
	public List<Bid> listAll();
	
}
