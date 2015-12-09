package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;

import ar.com.trimatec.copre.entities.Copre;
import ar.com.trimatec.copre.repositories.bi.CopreRepositoryBI;

public class HibernateCopreRepository extends HibernateBaseRepository implements CopreRepositoryBI {

	public Copre findById(Integer id) {
		Copre copre = (Copre) this.findById(Copre.class, id);
		return copre;
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
	public Copre findCopre() {
		return this.findById(0);
	}
	
}
