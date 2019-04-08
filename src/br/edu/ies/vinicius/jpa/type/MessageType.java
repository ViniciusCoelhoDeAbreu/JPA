package br.edu.ies.vinicius.jpa.type;

public enum MessageType {

	PERSISTENCE_UNIT_NAME("pessoasPU");

	private String value;

	private MessageType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
