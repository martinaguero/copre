package ar.com.trimatec.copre.repositories.bi;

import java.util.List;

import ar.com.trimatec.copre.entities.Requirement;

public interface RequirementRepositoryBI extends CopreAbstractRepositoryBI {

	public Requirement findRequirement(Integer id);

	public List<Requirement> listAll();

}
