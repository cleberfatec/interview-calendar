package br.com.interview.service;

import java.util.List;

import br.com.interview.model.Slot;

public interface SlotService {
	
	List<Slot> findAll();
	
	void save(Slot slot);
	
	Slot queryPossibleInterviews();

}
