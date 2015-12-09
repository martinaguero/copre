package ar.com.trimatec.copre.services.bi;

import java.util.List;

import ar.com.trimatec.copre.dto.WorkflowNodeDTO;
import ar.com.trimatec.copre.entities.Item;
import ar.com.trimatec.copre.entities.Participant;
import ar.com.trimatec.copre.entities.Requirement;
import ar.com.trimatec.copre.misc.RequirementStateEnum;

public interface RequirementService {

	public List<Item> listItemsByRequirementId(Integer requirementId);

	public Requirement updateRequirementWorkflowNode(Requirement requirement,
			RequirementStateEnum status);
	
	public List<Requirement> loadFilteredRequirements();
	
	public List<WorkflowNodeDTO> loadRequirementHistory(Integer requirementId);
	
	public Requirement addRequirement(List<Item> items, Participant participant);

}
