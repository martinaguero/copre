package ar.com.trimatec.copre.misc;

public enum RequirementStateEnum {
	NEW(1), DISPLAYED(2), BIDDED(3), ACCEPTED(4), FINALIZED(5);

	private Integer id;

	private RequirementStateEnum(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
