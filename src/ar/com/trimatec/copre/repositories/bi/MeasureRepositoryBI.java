package ar.com.trimatec.copre.repositories.bi;

import java.util.List;

import ar.com.trimatec.copre.entities.Measure;

public interface MeasureRepositoryBI extends CopreAbstractRepositoryBI {

	public Measure findMeasure(Integer id);
	
	public List<Measure> listAll();
	
}
