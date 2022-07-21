package br.com.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.interview.model.Interviewer;

public interface InterviewerRepository extends JpaRepository<Interviewer, Long> {

}
