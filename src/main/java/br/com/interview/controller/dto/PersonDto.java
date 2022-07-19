package br.com.interview.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.interview.model.Person;
import lombok.Data;

@Data
public class PersonDto {

	@JsonInclude(Include.NON_NULL)
	private Long id;

	@JsonInclude(Include.NON_NULL)
	private String name;

	@JsonInclude(Include.NON_NULL)
	private LocalDateTime creationDate;

	@JsonInclude(Include.NON_NULL)
	private String status;

	@JsonInclude(Include.NON_NULL)
	private String role;

	public PersonDto(Person person) {
		this.id = person.getId();
		this.name = person.getName();
		this.creationDate = person.getCreationDate();
		this.status = person.getStatus().name();
		this.role = person.getType().name();
	}

	public static List<PersonDto> converter(List<Person> person) {
		return person.stream().map(PersonDto::new).collect(Collectors.toList());
	}

}
