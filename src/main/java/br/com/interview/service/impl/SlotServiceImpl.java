package br.com.interview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.interview.model.Slot;
import br.com.interview.repository.SlotRepository;
import br.com.interview.service.SlotService;
import lombok.Data;

@Service
@Data
public class SlotServiceImpl implements SlotService {
	
	@Autowired
	private SlotRepository slotRepository;

	public List<Slot> findAll() {
		return slotRepository.findAll();
	}
	
	public void save(Slot slot) {
		slotRepository.save(slot);
	}
	
	public Slot queryPossibleInterviews() {
		return slotRepository.queryPossibleInterviews();
	}

}
