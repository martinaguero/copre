package ar.com.trimatec.copre.services.bi;

import java.util.List;

import ar.com.trimatec.copre.entities.Item;
import ar.com.trimatec.copre.entities.Participant;
import ar.com.trimatec.copre.entities.Requirement;
import ar.com.trimatec.copre.model.exceptions.ParticipantCuitNotUniqueException;

public interface ParticipantService {

	public Participant addUser(String companyName, String cuit, String address,
			String telephone, String email, String password,
			String[] selectedCategoriesId)
			throws ParticipantCuitNotUniqueException;

	public Participant findParticipant(Integer id);

}
