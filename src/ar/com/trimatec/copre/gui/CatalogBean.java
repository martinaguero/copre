package ar.com.trimatec.copre.gui;

import javax.faces.event.ActionEvent;

import ar.com.trimatec.copre.entities.Product;
import ar.com.trimatec.copre.model.exceptions.ProductBarCodeNotUniqueException;

public class CatalogBean extends CommonBean {

	private Integer id;
	private String barCode;
	private String productName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	private Product addProduct() throws ProductBarCodeNotUniqueException {

		return getCatalogService().addProduct(getSelectedBrand(), getBarCode(),
				getProductName(), getSelectedCategories());
	}

	public void addProduct(ActionEvent event)
			throws ProductBarCodeNotUniqueException {

		Product product = addProduct();
		if (product != null) {
			loadProperties(product);
		}
	}

	private void loadProperties(Product product) {
		setId(product.getId());
		setBarCode(product.getBarCode());
		setProductName(product.getName());
	}

}