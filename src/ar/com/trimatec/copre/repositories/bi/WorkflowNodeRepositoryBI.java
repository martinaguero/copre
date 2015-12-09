package ar.com.trimatec.copre.repositories.bi;

import java.util.List;

import ar.com.trimatec.copre.entities.WorkflowNode;

public interface WorkflowNodeRepositoryBI extends CopreAbstractRepositoryBI {

	public List<WorkflowNode> listWorklowNodesByRequirementId(
			Integer requirementId);

}
