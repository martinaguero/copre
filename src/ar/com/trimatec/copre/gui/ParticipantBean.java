package ar.com.trimatec.copre.gui;

import javax.faces.event.ActionEvent;

import ar.com.trimatec.copre.entities.Participant;
import ar.com.trimatec.copre.model.exceptions.ParticipantCuitNotUniqueException;

public class ParticipantBean extends CommonBean {

	private Integer id;
	private String companyName;
	private String cuit;
	private String telephone;
	private String address;
	private String email;
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Participant addParticipant()
			throws ParticipantCuitNotUniqueException {

		Participant participant = getParticipantService().addUser(
				getCompanyName(), getCuit(), getAddress(), getTelephone(),
				getEmail(), getPassword(), getSelectedCategories());
		return participant;
	}

	public void addParticipant(ActionEvent event)
			throws ParticipantCuitNotUniqueException {

		Participant participant = addParticipant();
		if (participant != null) {
			loadProperties(participant);
		}

	}

	private void loadProperties(Participant participant) {
		setId(participant.getId());
		setCompanyName(participant.getCompanyName());
		setCuit(participant.getCuit());
		setTelephone(participant.getTelephone());
		setAddress(participant.getAddress());
		setEmail(participant.getEmail());
		setPassword(participant.getPassword());
	}

}