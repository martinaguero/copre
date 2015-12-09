package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;
import java.util.List;

import ar.com.trimatec.copre.entities.Category;
import ar.com.trimatec.copre.repositories.bi.CategoryRepositoryBI;

public class HibernateCategoryRepository extends HibernateBaseRepository implements CategoryRepositoryBI {

	public Category findById(Integer id) {
		Category category = (Category) this.findById(Category.class, id);
		return category;
	}

	@Override
	public void delete(Object anObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObjects(Collection<? extends Object> someObjects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category findCategory(Integer id) {
		return this.findById(id);
	}

	@Override
	public List<Category> listAll() {
		return this.loadAll(Category.class);
	}
	
}
