package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;
import java.util.List;

import ar.com.trimatec.copre.entities.Brand;
import ar.com.trimatec.copre.repositories.bi.BrandRepositoryBI;

public class HibernateBrandRepository extends HibernateBaseRepository
		implements BrandRepositoryBI {

	public Brand findById(Integer id) {
		Brand brand = (Brand) this.findById(
				Brand.class, id);
		return brand;
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
	public List<Brand> listAll() {
		return this.loadAll(Brand.class);
	}

	@Override
	public Brand findBrand(Integer id) {
		return findById(id);
	}

}
