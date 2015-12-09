package ar.com.trimatec.copre.repositories.bi;

import java.util.List;

import ar.com.trimatec.copre.entities.Item;

public interface ItemRepositoryBI extends CopreAbstractRepositoryBI {

	public Item findItem(Integer id);
	
	public List<Item> listAll();
	
}
