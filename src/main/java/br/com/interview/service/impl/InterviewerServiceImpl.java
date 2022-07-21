package br.com.interview.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.interview.model.Interviewer;
import br.com.interview.repository.InterviewerRepository;
import br.com.interview.service.InterviewerService;
import lombok.Data;

@Service
@Data
public class InterviewerServiceImpl implements InterviewerService {

	@Autowired
	private InterviewerRepository interviewerRepository;

	public Optional<Interviewer> findById(Long interviewerId) {

		return interviewerRepository.findById(interviewerId);
	}

	public Interviewer save(Interviewer interviewer) {
		return interviewerRepository.save(interviewer);
	}

	@Override
	public List<Interviewer> findAll() {
		return interviewerRepository.findAll();
	}

}
