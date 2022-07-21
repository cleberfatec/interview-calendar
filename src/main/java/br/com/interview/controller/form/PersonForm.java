package br.com.interview.controller.form;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonForm {

	@NotNull
	private Long id;

	@NotNull
	private String name;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate slotDate;
		
	@JsonFormat(pattern="HH:mm")
	private LocalTime initTime;

	@JsonFormat(pattern="HH:mm")
	private LocalTime endTime;

}
