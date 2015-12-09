package ar.com.trimatec.copre.repositories.bi;

import java.util.List;

import ar.com.trimatec.copre.entities.Product;

public interface ProductRepositoryBI extends CopreAbstractRepositoryBI {

	public Product findProduct(Integer id);
	
	public List<Product> listAll();
	
	public Product findByBarCode(String barCode);
	
}
