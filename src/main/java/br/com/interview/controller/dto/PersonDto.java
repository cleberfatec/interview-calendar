package br.com.interview.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.interview.model.Candidate;
import br.com.interview.model.Interviewer;
import br.com.interview.model.TypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDto {

	@JsonInclude(Include.NON_NULL)
	private Long id;

	@JsonInclude(Include.NON_NULL)
	private String name;

	@JsonInclude(Include.NON_NULL)
	private LocalDate slotDate;

	@JsonInclude(Include.NON_NULL)
	private LocalTime initTime;

	@JsonInclude(Include.NON_NULL)
	private LocalTime endTime;
	
	@JsonInclude(Include.NON_NULL)
	private LocalDateTime creationDate;
	
	@JsonInclude(Include.NON_NULL)
	private String role;
	
	@JsonInclude(Include.NON_NULL)
    private String status;
    
	public PersonDto(Interviewer person) {
		this.id = person.getId();
		this.name = person.getName();
		this.creationDate = person.getCreationDate();
		this.status = person.getStatus().name();
		this.role = TypeEnum.INTERVIEWER.name();
	}

	public PersonDto(Candidate person) {
		this.id = person.getId();
		this.name = person.getName();
		this.creationDate = person.getCreationDate();
		this.status = person.getStatus().name();
		this.role = TypeEnum.CANDIDATE.name();
	}

	public static List<PersonDto> converter(List<Interviewer> person) {
		return person.stream().map(PersonDto::new).collect(Collectors.toList());
	}	

}
