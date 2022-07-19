package br.com.interview.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.interview.model.Person;
import br.com.interview.repository.PersonRepository;
import br.com.interview.service.PersonService;
import lombok.Data;

@Service
@Data
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Optional<Person> findById(Long personId) {

		return personRepository.findById(personId);
	}

	public void save(Person person) {
		personRepository.save(person);
	}

}
