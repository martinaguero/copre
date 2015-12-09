package ar.com.trimatec.copre.repositories.bi;

import java.util.List;

import ar.com.trimatec.copre.entities.Brand;

public interface BrandRepositoryBI extends CopreAbstractRepositoryBI {

	public Brand findBrand(Integer id);
	
	public List<Brand> listAll();
	
}
