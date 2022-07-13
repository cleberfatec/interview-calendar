package br.com.interview.controller.form;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SlotForm {

	private Long personId;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate slotDate;
		
	@JsonFormat(pattern="HH:mm")
	private LocalTime initTime;

	@JsonFormat(pattern="HH:mm")
	private LocalTime endTime;

	private Boolean repeat;
		
	private Boolean repeatEveryday;
	
	private Boolean repeatEveryweek;

	
	public SlotForm() {
		super();
	}

	public SlotForm(Long personId, LocalDate slotDate, LocalTime initTime, LocalTime endTime, Boolean repeat,
			Boolean repeatEveryday, Boolean repeatEveryweek) {
		super();
		this.personId = personId;
		this.slotDate = slotDate;
		this.initTime = initTime;
		this.endTime = endTime;
		this.repeat = repeat;
		this.repeatEveryday = repeatEveryday;
		this.repeatEveryweek = repeatEveryweek;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
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
