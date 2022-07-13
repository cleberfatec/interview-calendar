package br.com.interview.controller.dto;

public class SlotErrorDto extends SlotDto {	

	private String message;

	
	public SlotErrorDto() {
		super();	
	}

	public SlotErrorDto(Long personId, String message) {
		super();
		this.personId = personId;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

		
}
