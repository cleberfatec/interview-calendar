package br.com.interview.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.interview.model.Person;

public class PersonDto {

	private Long id;
	private String name;	
	private LocalDateTime creationDate;
	private String status;
	private String role;
	
	public PersonDto(Person person) {
		this.id = person.getId();
		this.name = person.getName();
		this.creationDate = person.getCreationDate();
		this.status = person.getStatus().name();
		this.role = person.getType().name();
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	public LocalDateTime getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public static List<PersonDto> converter(List<Person> person) {
		return person.stream().map(PersonDto::new).collect(Collectors.toList());
	}

}
