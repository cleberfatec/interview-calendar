package br.com.interview.service;

import java.util.List;
import java.util.Optional;

import br.com.interview.model.Interviewer;

public interface InterviewerService {

	 Optional<Interviewer> findById(Long personId);
	 
	 Interviewer save(Interviewer person);

	List<Interviewer> findAll();
}
