package ar.com.trimatec.copre.services.impl;

import ar.com.trimatec.copre.entities.Copre;
import ar.com.trimatec.copre.entities.Participant;
import ar.com.trimatec.copre.model.exceptions.ParticipantCuitNotUniqueException;
import ar.com.trimatec.copre.services.bi.ParticipantService;

public class ParticipantServiceImpl extends BaseServiceImpl implements
		ParticipantService {

	@Override
	public Participant addUser(String companyName, String cuit, String address,
			String telephone, String email, String password,
			String[] selectedCategoriesId)
			throws ParticipantCuitNotUniqueException {

		Copre copre = getCopreRepository().findCopre();
		Participant p = copre.addParticipant(companyName, cuit, address,
				telephone, email, password,
				prepareSelectedCategories(selectedCategoriesId));
		return p;
	}

	public Participant findParticipant(Integer id) {
		return (Participant) getParticipantRepository().findById(id);
	}

}
