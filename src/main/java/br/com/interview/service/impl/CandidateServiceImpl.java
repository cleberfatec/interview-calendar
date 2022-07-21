package br.com.interview.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.interview.model.Candidate;
import br.com.interview.repository.CandidateRepository;
import br.com.interview.service.CandidateService;
import lombok.Data;

@Service
@Data
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	public Optional<Candidate> findById(Long candidateId) {

		return candidateRepository.findById(candidateId);
	}

	public Candidate save(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	@Override
	public List<Candidate> findAll() {
		return candidateRepository.findAll();
	}

}
