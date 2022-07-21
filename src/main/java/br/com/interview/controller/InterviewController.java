package br.com.interview.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.interview.controller.dto.CandidateDto;
import br.com.interview.controller.dto.InterviewerDto;
import br.com.interview.controller.dto.MessageDto;
import br.com.interview.controller.dto.PersonDto;
import br.com.interview.controller.dto.PossibleInterviewsDto;
import br.com.interview.controller.form.PersonForm;
import br.com.interview.model.Candidate;
import br.com.interview.model.Interviewer;
import br.com.interview.model.Status;
import br.com.interview.service.CandidateService;
import br.com.interview.service.InterviewerService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/interview")
public class InterviewController {

	
	@Autowired
	CandidateService candidateService;
	
	@Autowired
	InterviewerService interviewerService;
	
	@GetMapping
	public ResponseEntity<?> queryPossibleInterviews() {
		
		List<Candidate> listCandidate = candidateService.findAll();
		List<Interviewer> listInterviewer = interviewerService.findAll();
		
		PossibleInterviewsDto possibleInterviewsDto = PossibleInterviewsDto.builder().build();	
		possibleInterviewsDto.setCandidateDtos(new ArrayList<>());
		
		listCandidate.stream().forEach(ca -> {		
			List<Interviewer> interviewer = listInterviewer.stream()
				.filter(inter -> ca.getInitTime().isAfter(inter.getInitTime()) || ca.getInitTime().compareTo(inter.getInitTime()) == 0)
				.filter(inter -> ca.getEndTime().isBefore(inter.getEndTime())|| ca.getEndTime().compareTo(inter.getEndTime()) == 0)
				.filter(inter -> ca.getSlotDate().equals(inter.getSlotDate()))
				.collect(Collectors.toList());
			
			if (!interviewer.isEmpty()) {
				CandidateDto candidateDto = new CandidateDto(ca);
				candidateDto.setInterviewers(InterviewerDto.converter(interviewer));	
				possibleInterviewsDto.getCandidateDtos().add(candidateDto);
			}
			
		});		
				
		
		return ResponseEntity.ok().body(possibleInterviewsDto);
	}
	
	@PostMapping("/interviewer")
	@Transactional
	@ApiOperation(value = "Register interviewer",
	  notes = "Endpoint responsible for register the interviewer. First it checks whether the person exist, if not it is created and return http 201, otherwise, return http 200",
	  response = PersonDto.class,
	  responseContainer = "PersonDto")
	public ResponseEntity<?> registerInterviewer(@RequestBody @Valid PersonForm form,
			UriComponentsBuilder uriBuilder) {

		Optional<Interviewer> personDb = interviewerService.findById(form.getId());
		if (!personDb.isPresent()) {

			Interviewer person = new Interviewer(form.getId(), form.getName(), LocalDateTime.now(), form.getSlotDate(), form.getInitTime(), form.getEndTime(), Status.ACTIVE);
			interviewerService.save(person);

			URI uri = uriBuilder.path("interview/interviewer/{id}").buildAndExpand(person.getId()).toUri();

			return ResponseEntity.created(uri).body(new PersonDto(person));
		}
		return ResponseEntity.ok().body(new MessageDto("Person already register with id: " + form.getId()));
		
	}

	@PostMapping("/candidate")
	@Transactional
	@ApiOperation(value = "Register candidate",
	  notes = "Endpoint responsible for register the candidate. First it checks whether the person exist, if not it is created and return http 201, otherwise, return http 200",
	  response = PersonDto.class,
	  responseContainer = "PersonDto")
	public ResponseEntity<?> registerCandidate(@RequestBody @Valid PersonForm form,
			UriComponentsBuilder uriBuilder) {

		Optional<Candidate> personDb = candidateService.findById(form.getId());
		if (!personDb.isPresent()) {

			Candidate person = new Candidate(form.getId(), form.getName(), LocalDateTime.now(), form.getSlotDate(), form.getInitTime(), form.getEndTime(), Status.ACTIVE);
			candidateService.save(person);

			URI uri = uriBuilder.path("interview/candidate/{id}").buildAndExpand(person.getId()).toUri();

			return ResponseEntity.created(uri).body(new PersonDto(person));
		}
		return ResponseEntity.ok().body(new MessageDto("Person already register with id: " + form.getId()));
	}

}
