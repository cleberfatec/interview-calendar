package br.com.interview.service;

import java.util.Optional;

import br.com.interview.model.Person;

public interface PersonService {

	 Optional<Person> findById(Long personId);
	 
	 void save(Person person);
}
