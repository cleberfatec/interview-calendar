package br.com.interview.controller.dto;

import lombok.Data;

@Data
public class MessageDto {
		
	private String message;

	public MessageDto(String message) {
		super();
		this.message = message;
	}

}
