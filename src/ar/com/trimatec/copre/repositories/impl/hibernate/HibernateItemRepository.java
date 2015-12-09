package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;
import java.util.List;

import ar.com.trimatec.copre.entities.Item;
import ar.com.trimatec.copre.repositories.bi.ItemRepositoryBI;

public class HibernateItemRepository extends HibernateBaseRepository
		implements ItemRepositoryBI {

	public Item findById(Integer id) {
		Item item = (Item) this.findById(
				Item.class, id);
		return item;
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
	public List<Item> listAll() {
		return this.loadAll(Item.class);
	}

	@Override
	public Item findItem(Integer id) {
		return findById(id);
	}

}
