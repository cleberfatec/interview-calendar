package br.com.interview.controller.dto;

import java.util.List;

import br.com.interview.model.Candidate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CandidateDto extends PersonDto {

	
	private List<PersonDto> interviewers;

	public CandidateDto(Candidate person) {
		super(person);
	}
	
	
}
