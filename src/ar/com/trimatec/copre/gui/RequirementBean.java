package ar.com.trimatec.copre.gui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;

import ar.com.trimatec.copre.dto.WorkflowNodeDTO;
import ar.com.trimatec.copre.entities.Item;
import ar.com.trimatec.copre.entities.Participant;
import ar.com.trimatec.copre.entities.Product;
import ar.com.trimatec.copre.entities.Requirement;

public class RequirementBean extends CommonBean {

	private Map<String, Object> products = new LinkedHashMap<String, Object>();
	private String selectedProduct;
	private Product product;
	private Integer quantity;
	private List<Item> items = new ArrayList<Item>();
	private Requirement requirement;
	private Integer id;
	private List<WorkflowNodeDTO> workflowNodes;

	public String getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(String selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public void selectCategory(ActionEvent event) {
		products = loadProducts(getSelectedCategory());
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setProducts(Map<String, Object> products) {
		this.products = products;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Map<String, Object> loadProducts(String categoryId) {
		products.clear();
		List<Product> productList = getCatalogService().listProductsByCategory(
				categoryId);
		for (Product product : productList) {
			products.put(
					product.getBrand().getName() + "/" + product.getName(),
					product.getId());
		}
		return products;
	}

	public Map<String, Object> getProducts() {
		return products;
	}

	public void selectProduct(ActionEvent event) {
		product = getCatalogService().getProductById(getSelectedProduct());
	}

	public void saveItem(ActionEvent event) {
		Item item = new Item();
		item.setProduct(product);
		item.setMeasure(getCatalogService()
				.getMeasureById(getSelectedMeasure()));
		item.setQuantity(getQuantity());
		items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<WorkflowNodeDTO> getWorkflowNodes() {
		return workflowNodes;
	}

	public void setWorkflowNodes(List<WorkflowNodeDTO> workflowNodes) {
		this.workflowNodes = workflowNodes;
	}

	public void saveRequirement(ActionEvent event) {
		Participant participant = getParticipantService().findParticipant(105);
		requirement = getRequirementService()
				.addRequirement(items, participant);
		items.clear();
	}

	public void displayHistory(ActionEvent event) {
		workflowNodes = getRequirementService().loadRequirementHistory(id);
	}

}