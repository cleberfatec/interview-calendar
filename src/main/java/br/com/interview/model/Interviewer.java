package br.com.interview.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Interviewer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	private LocalDateTime creationDate = LocalDateTime.now();

	private LocalDate slotDate;

	private LocalTime initTime;

	private LocalTime endTime;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.INACTIVE;

	public Interviewer() {
	}



	public Interviewer(Long id, String name, LocalDateTime creationDate, LocalDate slotDate,
			LocalTime initTime, LocalTime endTime, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.slotDate = slotDate;
		this.initTime = initTime;
		this.endTime = endTime;
		this.status = status;
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



	public LocalDate getSlotDate() {
		return slotDate;
	}



	public void setSlotDate(LocalDate slotDate) {
		this.slotDate = slotDate;
	}



	public LocalTime getInitTime() {
		return initTime;
	}



	public void setInitTime(LocalTime initTime) {
		this.initTime = initTime;
	}



	public LocalTime getEndTime() {
		return endTime;
	}



	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}


	
}
