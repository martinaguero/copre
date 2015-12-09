package ar.com.trimatec.copre.services.impl;

import java.util.ArrayList;
import java.util.List;

import ar.com.trimatec.copre.dto.WorkflowNodeDTO;
import ar.com.trimatec.copre.entities.Copre;
import ar.com.trimatec.copre.entities.Item;
import ar.com.trimatec.copre.entities.Measure;
import ar.com.trimatec.copre.entities.Participant;
import ar.com.trimatec.copre.entities.Product;
import ar.com.trimatec.copre.entities.Requirement;
import ar.com.trimatec.copre.entities.WorkflowDescription;
import ar.com.trimatec.copre.entities.WorkflowNode;
import ar.com.trimatec.copre.entities.WorkflowNodeDescription;
import ar.com.trimatec.copre.misc.RequirementStateEnum;
import ar.com.trimatec.copre.services.bi.RequirementService;

public class RequirementServiceImpl extends BaseServiceImpl implements
		RequirementService {

	@Override
	public List<Item> listItemsByRequirementId(Integer requirementId) {
		Requirement requirement = (Requirement) getRequirementRepository()
				.findById(requirementId);
		List<Item> items = new ArrayList<Item>();
		for (Item item : requirement.getItems()) {
			items.add(item);
		}
		return items;
	}

	@Override
	public Requirement updateRequirementWorkflowNode(Requirement requirement,
			RequirementStateEnum status) {
		Copre copre = getCopreRepository().findCopre();
		requirement = copre.updateRequirementState(requirement);
		WorkflowNodeDescription nodeDescription = getWorkflowNodeDescriptionRepository()
				.findWorkflowNodeDescriptionById(status.getId());
		return copre.updateRequirementState(nodeDescription, requirement);
	}

	@Override
	public List<Requirement> loadFilteredRequirements() {
		List<Requirement> requirements = getRequirementRepository().listAll();
		return filterRequirements(requirements);
	}

	private List<Requirement> filterRequirements(List<Requirement> requirements) {
		Integer reqNodeDescId;
		List<Requirement> filteredRequirements = new ArrayList<Requirement>();
		for (Requirement requirement : requirements) {
			reqNodeDescId = requirement.getCurrentWorkflowNode()
					.getNodeDescription().getId();
			if (reqNodeDescId.equals(RequirementStateEnum.NEW.getId())
					|| reqNodeDescId.equals(RequirementStateEnum.DISPLAYED
							.getId())
					|| reqNodeDescId
							.equals(RequirementStateEnum.BIDDED.getId())) {
				filteredRequirements.add(requirement);
			}
		}
		return filteredRequirements;
	}

	@Override
	public List<WorkflowNodeDTO> loadRequirementHistory(Integer requirementId) {
		List<WorkflowNodeDTO> nodesDto = new ArrayList<WorkflowNodeDTO>();
		for (WorkflowNode workflowNode : getWorkflowNodeRepository()
				.listWorklowNodesByRequirementId(requirementId)) {
			WorkflowNodeDTO nodeDto = new WorkflowNodeDTO();
			nodeDto.setId(workflowNode.getId());
			nodeDto.setInitDate(workflowNode.getInitDate());
			nodeDto.setEndDate(workflowNode.getEndDate());
			nodeDto.setRequirementId(workflowNode.getRequirement().getId());
			nodeDto.setStatus(workflowNode.getNodeDescription().getTitle());
			nodesDto.add(nodeDto);
		}
		return nodesDto;
	}
	
	private List<Item> reloadItems(List<Item> items) {
		List<Item> reloadedItems = new ArrayList<Item>();
		Product product = null;
		Measure measure = null;
		for (Item item : items) {
			product = item.getProduct();
			measure = item.getMeasure();
			item.setProduct(loadProduct(product));
			item.setMeasure(loadMeasure(measure));
			reloadedItems.add(item);
		}
		return reloadedItems;
	}
	
	private Product loadProduct(Product product){
		return getProductRepository().findProduct(product.getId());
	}
	
	private Measure loadMeasure(Measure measure){
		return getMeasureRepository().findMeasure(measure.getId());
	}

	@Override
	public Requirement addRequirement(List<Item> items, Participant participant) {
		Copre copre = getCopreRepository().findCopre();
		WorkflowDescription wf = getWorkflowRepository().findWorkflow();
		Requirement requirement = copre.addRequirement(reloadItems(items), participant,
				wf.getInitialNodeDescription());
		return requirement;
	}
	
}
