package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;
import java.util.List;

import ar.com.trimatec.copre.entities.Requirement;
import ar.com.trimatec.copre.repositories.bi.RequirementRepositoryBI;

public class HibernateRequirementRepository extends HibernateBaseRepository implements RequirementRepositoryBI {

	public Requirement findById(Integer id) {
		Requirement requirement = (Requirement) this.findById(Requirement.class, id);
		return requirement;
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
	public Requirement findRequirement(Integer id) {
		return this.findById(id);
	}

	@Override
	public List<Requirement> listAll() {
		return this.loadAll(Requirement.class);
	}
	
}
