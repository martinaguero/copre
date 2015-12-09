package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;

import ar.com.trimatec.copre.entities.Copre;
import ar.com.trimatec.copre.entities.WorkflowDescription;
import ar.com.trimatec.copre.repositories.bi.WorkflowRepositoryBI;

public class HibernateWorkflowRepository extends HibernateBaseRepository implements WorkflowRepositoryBI {

	public WorkflowDescription findById(Integer id) {
		WorkflowDescription workflow = (WorkflowDescription) this.findById(WorkflowDescription.class, id);
		return workflow;
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
	public WorkflowDescription findWorkflow() {
		return this.findById(1);
	}
	
}
