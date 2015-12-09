package ar.com.trimatec.copre.repositories.bi;

import java.util.List;

import ar.com.trimatec.copre.entities.Participant;

public interface ParticipantRepositoryBI extends CopreAbstractRepositoryBI {

	public Participant findParticipant(Integer id);
	
	public List<Participant> listAll();
	
	public Participant findByCuit(String cuit);
	
}
