package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;

import ar.com.trimatec.copre.entities.WorkflowNodeDescription;
import ar.com.trimatec.copre.repositories.bi.WorkflowNodeDescriptionRepositoryBI;

public class HibernateWorkflowNodeDescriptionRepository extends
		HibernateBaseRepository implements WorkflowNodeDescriptionRepositoryBI {

	public WorkflowNodeDescription findById(Integer id) {
		WorkflowNodeDescription nodeDescription = (WorkflowNodeDescription) this
				.findById(WorkflowNodeDescription.class, id);
		return nodeDescription;
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
	public WorkflowNodeDescription findWorkflowNodeDescriptionById(Integer id) {
		return findById(id);
	}

}
