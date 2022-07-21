package br.com.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.interview.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
