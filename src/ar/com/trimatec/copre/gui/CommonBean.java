package ar.com.trimatec.copre.gui;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import ar.com.trimatec.copre.entities.Bid;
import ar.com.trimatec.copre.entities.Brand;
import ar.com.trimatec.copre.entities.Category;
import ar.com.trimatec.copre.entities.Measure;
import ar.com.trimatec.copre.entities.Requirement;
import ar.com.trimatec.copre.repositories.RepositoryLocator;
import ar.com.trimatec.copre.repositories.bi.BidRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.BrandRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.CategoryRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.MeasureRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.RequirementRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.WorkflowNodeDescriptionRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.WorkflowNodeRepositoryBI;
import ar.com.trimatec.copre.repositories.bi.WorkflowRepositoryBI;
import ar.com.trimatec.copre.services.bi.BidService;
import ar.com.trimatec.copre.services.bi.CatalogService;
import ar.com.trimatec.copre.services.bi.ParticipantService;
import ar.com.trimatec.copre.services.bi.RequirementService;

public class CommonBean {

	protected String selectedCategory;
	protected String[] selectedCategories;
	protected String selectedBrand;
	protected String selectedMeasure;
	protected ParticipantService participantService;
	protected CatalogService catalogService;
	protected RequirementService requirementService;
	protected BidService bidService;

	public String[] getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(String[] selectedCategories) {
		this.selectedCategories = selectedCategories;
	}

	public String getSelectedBrand() {
		return selectedBrand;
	}

	public void setSelectedBrand(String selectedBrand) {
		this.selectedBrand = selectedBrand;
	}

	public String getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public ParticipantService getParticipantService() {
		return participantService;
	}

	public void setParticipantService(ParticipantService participantService) {
		this.participantService = participantService;
	}

	public CatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public RequirementService getRequirementService() {
		return requirementService;
	}

	public void setRequirementService(RequirementService requirementService) {
		this.requirementService = requirementService;
	}

	public BidService getBidService() {
		return bidService;
	}

	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}

	public String getSelectedMeasure() {
		return selectedMeasure;
	}

	public void setSelectedMeasure(String selectedMeasure) {
		this.selectedMeasure = selectedMeasure;
	}

	public Map<String, Object> getCategories() {
		Map<String, Object> categories = new LinkedHashMap<String, Object>();
		List<Category> cats = getCategoryRepository().listAll();
		for (Category category : cats) {
			categories.put(category.getName(), category.getId());
		}
		return categories;
	}

	public Map<String, Object> getBrands() {
		List<Brand> brandsList = getBrandRepository().listAll();
		Map<String, Object> brands = new LinkedHashMap<String, Object>();
		for (Brand brand : brandsList) {
			brands.put(brand.getName(), brand.getId());
		}
		return brands;
	}

	public Map<String, Object> getMeasures() {
		List<Measure> measureList = getMeasureRepository().listAll();
		Map<String, Object> measures = new LinkedHashMap<String, Object>();
		for (Measure measure : measureList) {
			measures.put(measure.getName(), measure.getId());
		}
		return measures;
	}

	protected CategoryRepositoryBI getCategoryRepository() {
		return RepositoryLocator.getInstance().getCategoryRepository();
	}

	protected BrandRepositoryBI getBrandRepository() {
		return RepositoryLocator.getInstance().getBrandRepository();
	}

	protected MeasureRepositoryBI getMeasureRepository() {
		return RepositoryLocator.getInstance().getMeasureRepository();
	}

	protected RequirementRepositoryBI getRequirementRepository() {
		return RepositoryLocator.getInstance().getRequirementRepository();
	}

	protected WorkflowRepositoryBI getWorkflowRepository() {
		return RepositoryLocator.getInstance().getWorkflowRepository();
	}

	protected WorkflowNodeDescriptionRepositoryBI getWorkflowNodeDescriptionRepository() {
		return RepositoryLocator.getInstance()
				.getWorkflowNodeDescriptionRepository();
	}

	protected WorkflowNodeRepositoryBI getWorkflowNodeRepository() {
		return RepositoryLocator.getInstance().getWorkflowNodeRepository();
	}

	protected BidRepositoryBI getBidRepository() {
		return RepositoryLocator.getInstance().getBidRepository();
	}
	
	protected void redirectTo(String path) throws IOException{
			ExternalContext eContext = FacesContext.getCurrentInstance()
					.getExternalContext();
			eContext.redirect(eContext.getRequestContextPath() + path);
	}

}
