package br.com.interview.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.interview.model.Slot;

public class SlotDto {

	protected Long personId;

	@JsonInclude(Include.NON_NULL)
	private String personName;

	@JsonInclude(Include.NON_NULL)
	private Long scheduleId;

	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate slotDate;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "HH:mm")
	private LocalTime initTime;

	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "HH:mm")
	private LocalTime endTime;
	
	@JsonInclude(Include.NON_NULL)
	private Boolean repeat;

	@JsonInclude(Include.NON_NULL)
	private Boolean repeatEveryday;
	
	@JsonInclude(Include.NON_NULL)
	private Boolean repeatEveryweek;
	
	public SlotDto() {
	}

	public SlotDto(Slot slot) {
		super();
		this.personId = slot.getPerson().getId();
		this.personName = slot.getPerson().getName();
		this.scheduleId = slot.getId();
		this.initTime = slot.getInitTime();
		this.endTime = slot.getEndTime();
		this.slotDate = slot.getSlotDate();
		this.repeat = slot.getRepeat();
		this.repeatEveryday = slot.getRepeatEveryday();
		this.repeatEveryweek = slot.getRepeatEveryweek();
			
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
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

	public static List<SlotDto> converter(List<Slot> slots) {
		return slots.stream().map(SlotDto::new).collect(Collectors.toList());
	}
}
