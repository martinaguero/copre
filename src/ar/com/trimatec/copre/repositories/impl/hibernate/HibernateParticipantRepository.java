package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;

import ar.com.trimatec.copre.entities.Participant;
import ar.com.trimatec.copre.repositories.bi.ParticipantRepositoryBI;

public class HibernateParticipantRepository extends HibernateBaseRepository
		implements ParticipantRepositoryBI {

	public Participant findById(Integer id) {
		Participant participant = (Participant) this.findById(
				Participant.class, id);
		return participant;
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
	public List<Participant> listAll() {
		return this.loadAll(Participant.class);
	}

	@Override
	public Participant findByCuit(String cuit) {
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from Participant where cuit = :code ");
		query.setParameter("code", cuit);
		Participant result = (Participant) query.uniqueResult();
		return result;
	}

	@Override
	public Participant findParticipant(Integer id) {
		return findById(id);
	}

}
