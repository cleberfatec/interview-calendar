package br.com.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.interview.model.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long> {
	
	@Query("Select s from Slot s Join s.person p")
	Slot queryPossibleInterviews(); 

}
