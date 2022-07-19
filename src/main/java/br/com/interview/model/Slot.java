package br.com.interview.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Slot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Person person;

	private LocalDate slotDate;

	private LocalTime initTime;

	private LocalTime endTime;

	private Boolean repeat;

	private Boolean repeatEveryday;

	private Boolean repeatEveryweek;

	public Slot() {

	}

	public Slot(Person person, LocalDate slotDate, LocalTime initTime, LocalTime endTime, Boolean repeat,
			Boolean repeatEveryday, Boolean repeatEveryweek) {
		super();
		this.person = person;
		this.slotDate = slotDate;
		this.initTime = initTime;
		this.endTime = endTime;
		this.repeat = repeat;
		this.repeatEveryday = repeatEveryday;
		this.repeatEveryweek = repeatEveryweek;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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

	public Boolean getRepeat() {
		return repeat;
	}

	public void setRepeat(Boolean repeat) {
		this.repeat = repeat;
	}

	public Boolean getRepeatEveryday() {
		return repeatEveryday;
	}

	public void setRepeatEveryday(Boolean repeatEveryday) {
		this.repeatEveryday = repeatEveryday;
	}

	public Boolean getRepeatEveryweek() {
		return repeatEveryweek;
	}

	public void setRepeatEveryweek(Boolean repeatEveryweek) {
		this.repeatEveryweek = repeatEveryweek;
	}

}
