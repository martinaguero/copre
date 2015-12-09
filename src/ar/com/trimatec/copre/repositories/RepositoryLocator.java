package ar.com.trimatec.copre.repositories;

import ar.com.trimatec.copre.repositories.bi.BidRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.BrandRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.CategoryRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.CopreRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.ItemRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.MeasureRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.ParticipantRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.ProductRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.RequirementRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.WorkflowNodeDescriptionRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.WorkflowNodeRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.WorkflowRepositoryBI;

public class RepositoryLocator {

	private static RepositoryLocator instance;
	private CopreRepositoryBI copreRepository;
	private CategoryRepositoryBI categoryRepository;
	private ParticipantRepositoryBI participantRepository;
	private ProductRepositoryBI productRepository;
	private BrandRepositoryBI brandRepository;
	private MeasureRepositoryBI measureRepository;
	private ItemRepositoryBI itemRepository;
	private RequirementRepositoryBI requirementRepository;
	private WorkflowRepositoryBI workflowRepository;
	private WorkflowNodeDescriptionRepositoryBI workflowNodeDescriptionRepository;
	private BidRepositoryBI bidRepository;
	private WorkflowNodeRepositoryBI workflowNodeRepository;

	private RepositoryLocator() {
	}

	public CopreRepositoryBI getCopreRepository() {
		return copreRepository;
	}

	public void setCopreRepository(CopreRepositoryBI copreRepository) {
		this.copreRepository = copreRepository;
	}

	public CategoryRepositoryBI getCategoryRepository() {
		return categoryRepository;
	}

	public void setCategoryRepository(CategoryRepositoryBI categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public ParticipantRepositoryBI getParticipantRepository() {
		return participantRepository;
	}

	public void setParticipantRepository(
			ParticipantRepositoryBI participantRepository) {
		this.participantRepository = participantRepository;
	}

	public ProductRepositoryBI getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepositoryBI productRepository) {
		this.productRepository = productRepository;
	}

	public BrandRepositoryBI getBrandRepository() {
		return brandRepository;
	}

	public void setBrandRepository(BrandRepositoryBI brandRepository) {
		this.brandRepository = brandRepository;
	}

	public MeasureRepositoryBI getMeasureRepository() {
		return measureRepository;
	}

	public void setMeasureRepository(MeasureRepositoryBI measureRepository) {
		this.measureRepository = measureRepository;
	}

	public ItemRepositoryBI getItemRepository() {
		return itemRepository;
	}

	public void setItemRepository(ItemRepositoryBI itemRepository) {
		this.itemRepository = itemRepository;
	}

	public RequirementRepositoryBI getRequirementRepository() {
		return requirementRepository;
	}

	public void setRequirementRepository(
			RequirementRepositoryBI requirementRepository) {
		this.requirementRepository = requirementRepository;
	}

	public WorkflowRepositoryBI getWorkflowRepository() {
		return workflowRepository;
	}

	public void setWorkflowRepository(WorkflowRepositoryBI workflowRepository) {
		this.workflowRepository = workflowRepository;
	}

	public WorkflowNodeDescriptionRepositoryBI getWorkflowNodeDescriptionRepository() {
		return workflowNodeDescriptionRepository;
	}

	public void setWorkflowNodeDescriptionRepository(
			WorkflowNodeDescriptionRepositoryBI workflowNodeDescriptionRepository) {
		this.workflowNodeDescriptionRepository = workflowNodeDescriptionRepository;
	}

	public BidRepositoryBI getBidRepository() {
		return bidRepository;
	}

	public void setBidRepository(BidRepositoryBI bidRepository) {
		this.bidRepository = bidRepository;
	}

	public WorkflowNodeRepositoryBI getWorkflowNodeRepository() {
		return workflowNodeRepository;
	}

	public void setWorkflowNodeRepository(
			WorkflowNodeRepositoryBI workflowNodeRepository) {
		this.workflowNodeRepository = workflowNodeRepository;
	}

	public static RepositoryLocator getInstance() {
		if (instance == null) {
			instance = new RepositoryLocator();
		}
		return instance;
	}

}
