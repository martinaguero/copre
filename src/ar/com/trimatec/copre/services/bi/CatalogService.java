package ar.com.trimatec.copre.services.bi;

import java.util.List;

import ar.com.trimatec.copre.entities.Measure;
import ar.com.trimatec.copre.entities.Product;
import ar.com.trimatec.copre.model.exceptions.ProductBarCodeNotUniqueException;

public interface CatalogService {

	public Product addProduct(String brand, String barCode, String name,
			String[] selectedCategoriesId)
			throws ProductBarCodeNotUniqueException;

	public List<Product> listProductsByCategory(String selectedCategoryId);
	
	public Product getProductById(String selectedProductId);
	
	public Measure getMeasureById(String selectedMeasureId);

}
