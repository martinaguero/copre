package ar.com.trimatec.copre.repositories.bi;

import java.util.List;

import ar.com.trimatec.copre.entities.Category;

public interface CategoryRepositoryBI extends CopreAbstractRepositoryBI {

	public Category findCategory(Integer id);
	
	public List<Category> listAll();
	
}
