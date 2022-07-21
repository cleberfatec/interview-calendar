package br.com.interview.controller.dto;

import br.com.interview.model.Interviewer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class InterviewerDto extends PersonDto {
	
	public InterviewerDto(Interviewer person) {
		super(person);
	}

}
