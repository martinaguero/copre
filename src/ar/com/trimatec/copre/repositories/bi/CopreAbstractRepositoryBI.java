package ar.com.trimatec.copre.repositories.bi;

import java.util.Collection;

public interface CopreAbstractRepositoryBI {

	public Object findById(Integer anOId);

	public void delete(Object anObject);

	public void deleteObjects(Collection<? extends Object> someObjects);
	
}
