package ar.com.trimatec.copre.repositories.bi;

import ar.com.trimatec.copre.entities.WorkflowDescription;

public interface WorkflowRepositoryBI extends CopreAbstractRepositoryBI {

	public WorkflowDescription findWorkflow();

}
