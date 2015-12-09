package ar.com.trimatec.copre.entities;

import java.util.HashSet;
import java.util.Set;

import ar.com.trimatec.copre.model.exceptions.ProductBarCodeNotUniqueException;
import ar.com.trimatec.copre.repositories.RepositoryLocator;
import ar.com.trimatec.copre.repositories.bi.ProductRepositoryBI;

public class Category {

	private Integer id;
	private String name;
	private Set<Product> products;
	private Copre copre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Copre getCopre() {
		return copre;
	}

	public void setCopre(Copre copre) {
		this.copre = copre;
	}

	public void addProduct(Product product) {
		if (products == null) {
			products = new HashSet();
		}
		products.add(product);
	}

	public Product addProduct(Brand brand, String barCode, String productName)
			throws ProductBarCodeNotUniqueException {

		Product product = this.getProductRepository().findByBarCode(barCode);
		if (product == null) {
			product = new Product();
			product.setBrand(brand);
			product.setBarCode(barCode);
			product.setName(productName);
			if (products == null) {
				products = new HashSet();
			}
		} else {
			throw new ProductBarCodeNotUniqueException();
		}
		products.add(product);
		return product;
	}

	private ProductRepositoryBI getProductRepository() {
		return RepositoryLocator.getInstance().getProductRepository();
	}
}
