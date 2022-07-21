package br.com.interview.service;

import java.util.List;
import java.util.Optional;

import br.com.interview.model.Candidate;

public interface CandidateService {

	 Optional<Candidate> findById(Long personId);
	 
	 Candidate save(Candidate person);

	List<Candidate> findAll();
}
