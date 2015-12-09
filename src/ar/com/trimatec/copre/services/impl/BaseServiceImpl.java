package ar.com.trimatec.copre.services.impl;

import java.util.HashSet;
import java.util.Set;

import ar.com.trimatec.copre.entities.Category;
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

public class BaseServiceImpl {

	protected CopreRepositoryBI copreRepository;
	protected CategoryRepositoryBI categoryRepository;
	protected ParticipantRepositoryBI participantRepository;
	protected ProductRepositoryBI productRepository;
	protected BrandRepositoryBI brandRepository;
	protected MeasureRepositoryBI measureRepository;
	protected ItemRepositoryBI itemRepository;
	protected RequirementRepositoryBI requirementRepository;
	protected WorkflowRepositoryBI workflowRepository;
	protected WorkflowNodeDescriptionRepositoryBI workflowNodeDescriptionRepository;
	protected BidRepositoryBI bidRepository;
	protected WorkflowNodeRepositoryBI workflowNodeRepository;

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

	protected Set<Category> prepareSelectedCategories(
			String[] selectedCategoriesId) {
		Set<Category> selCategories = new HashSet<Category>();
		for (int i = 0; i < selectedCategoriesId.length; i++) {
			Category cat = (Category) getCategoryRepository().findById(
					new Integer(selectedCategoriesId[i]));
			selCategories.add(cat);
		}
		return selCategories;
	}

}
