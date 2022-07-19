package br.com.interview.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class SlotErrorDto extends SlotDto {

	private String message;

	public SlotErrorDto(Long personId, String message) {
		this.personId = personId;
		this.message = message;
	}

}
