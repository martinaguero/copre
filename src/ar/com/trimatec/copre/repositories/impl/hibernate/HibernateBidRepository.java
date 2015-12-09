package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;
import java.util.List;

import ar.com.trimatec.copre.entities.Bid;
import ar.com.trimatec.copre.repositories.bi.BidRepositoryBI;

public class HibernateBidRepository extends HibernateBaseRepository implements
		BidRepositoryBI {

	public Bid findById(Integer id) {
		Bid bid = (Bid) this.findById(Bid.class, id);
		return bid;
	}

	@Override
	public void delete(Object anObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteObjects(Collection<? extends Object> someObjects) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Bid> listAll() {
		return this.loadAll(Bid.class);
	}

	@Override
	public Bid findBid(Integer id) {
		return findById(id);
	}

}
