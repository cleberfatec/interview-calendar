package br.com.interview.config.validation;

public class AdviceDto {

	private String field;
	private String error;

	public AdviceDto(String field, String error) {
		super();
		this.field = field;
		this.error = error;
	}

	public String getField() {
		return field;
	}

	public String getError() {
		return error;
	}

}
