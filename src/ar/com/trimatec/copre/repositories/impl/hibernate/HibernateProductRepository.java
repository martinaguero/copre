package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;

import ar.com.trimatec.copre.entities.Product;
import ar.com.trimatec.copre.repositories.bi.ProductRepositoryBI;

public class HibernateProductRepository extends HibernateBaseRepository
		implements ProductRepositoryBI {

	public Product findById(Integer id) {
		Product product = (Product) this.findById(
				Product.class, id);
		return product;
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
	public List<Product> listAll() {
		return this.loadAll(Product.class);
	}

	@Override
	public Product findByBarCode(String barCode) {
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from Product where barCode = :barCode ");
		query.setParameter("barCode", barCode);
		Product result = (Product) query.uniqueResult();
		return result;
	}

	@Override
	public Product findProduct(Integer id) {
		return findById(id);
	}

}
