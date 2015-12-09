package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;

import ar.com.trimatec.copre.entities.WorkflowNode;
import ar.com.trimatec.copre.repositories.bi.WorkflowNodeRepositoryBI;

public class HibernateWorkflowNodeRepository extends
		HibernateBaseRepository implements WorkflowNodeRepositoryBI {

	@Override
	public Object findById(Integer anOId) {
		// TODO Auto-generated method stub
		return null;
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
	public List<WorkflowNode> listWorklowNodesByRequirementId(
			Integer requirementId) {
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from WorkflowNode where requirement_id = :id order by id desc");
		query.setParameter("id", requirementId);
		return query.list();
	}



}
