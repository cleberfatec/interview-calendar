package br.com.interview.controller.form;

import javax.validation.constraints.NotNull;

public class PersonForm {

	@NotNull
	private Long id;

	@NotNull
	private String name;

	
	public PersonForm() {
		super();
	}

	public PersonForm(@NotNull Long id, @NotNull String name) {
		super();
		this.id = id;
		this.name = name;
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

}
