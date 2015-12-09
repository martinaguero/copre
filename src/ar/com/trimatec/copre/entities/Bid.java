package ar.com.trimatec.copre.entities;

import java.math.BigDecimal;

public class Bid {

	private Integer id;
	private BigDecimal price;
	private String comment;
	private Boolean accepted;
	private Requirement requirement;
	private Participant participant;
	private Copre copre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Copre getCopre() {
		return copre;
	}

	public void setCopre(Copre copre) {
		this.copre = copre;
	}

}
