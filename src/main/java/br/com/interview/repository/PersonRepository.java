package br.com.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.interview.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
