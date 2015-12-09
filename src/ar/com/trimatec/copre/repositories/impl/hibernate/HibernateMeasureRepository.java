package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;
import java.util.List;

import ar.com.trimatec.copre.entities.Measure;
import ar.com.trimatec.copre.repositories.bi.MeasureRepositoryBI;

public class HibernateMeasureRepository extends HibernateBaseRepository
		implements MeasureRepositoryBI {

	public Measure findById(Integer id) {
		Measure measure = (Measure) this.findById(
				Measure.class, id);
		return measure;
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
	public List<Measure> listAll() {
		return this.loadAll(Measure.class);
	}

	@Override
	public Measure findMeasure(Integer id) {
		return findById(id);
	}


}
