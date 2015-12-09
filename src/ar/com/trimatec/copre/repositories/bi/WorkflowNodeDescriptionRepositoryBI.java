package ar.com.trimatec.copre.repositories.bi;

import ar.com.trimatec.copre.entities.WorkflowNodeDescription;

public interface WorkflowNodeDescriptionRepositoryBI extends
		CopreAbstractRepositoryBI {

	public WorkflowNodeDescription findWorkflowNodeDescriptionById(Integer id);

}
