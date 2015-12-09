package ar.com.trimatec.copre.services.impl;

import java.util.ArrayList;
import java.util.List;

import ar.com.trimatec.copre.entities.Brand;
import ar.com.trimatec.copre.entities.Category;
import ar.com.trimatec.copre.entities.Measure;
import ar.com.trimatec.copre.entities.Product;
import ar.com.trimatec.copre.model.exceptions.ProductBarCodeNotUniqueException;
import ar.com.trimatec.copre.services.bi.CatalogService;

public class CatalogServiceImpl extends BaseServiceImpl implements
		CatalogService {

	@Override
	public Product addProduct(String brand, String barCode, String name,
			String[] selectedCategoriesId)
			throws ProductBarCodeNotUniqueException {

		Product product = null;
		Brand b = (Brand) getBrandRepository().findById(new Integer(brand));
		for (int i = 0; i < selectedCategoriesId.length; i++) {
			Category category = (Category) getCategoryRepository().findById(
					new Integer(selectedCategoriesId[i]));
			product = category.addProduct(b, barCode, name);
		}
		return product;
	}

	public List<Product> listProductsByCategory(String selectedCategoryId) {
		Category category = (Category) getCategoryRepository().findById(
				new Integer(selectedCategoryId));
		List<Product> productList = new ArrayList<Product>();
		for (Product product : category.getProducts()) {
			Brand brand = (Brand) getBrandRepository().findBrand(
					product.getBrand().getId());
			product.setBrand(brand);
			productList.add(product);
		}
		return productList;
	}

	public Product getProductById(String selectedProductId) {
		Product product = (Product) getProductRepository().findProduct(
				new Integer(selectedProductId));
		Brand brand = (Brand) getBrandRepository().findBrand(
				product.getBrand().getId());
		product.setBrand(brand);
		return product;
	}

	public Measure getMeasureById(String selectedMeasureId) {
		Measure measure = (Measure) getMeasureRepository().findMeasure(
				new Integer(selectedMeasureId));
		return measure;
	}

}
