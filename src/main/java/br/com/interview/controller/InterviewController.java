package br.com.interview.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.interview.controller.dto.MessageDto;
import br.com.interview.controller.dto.PersonDto;
import br.com.interview.controller.dto.SlotDto;
import br.com.interview.controller.dto.SlotErrorDto;
import br.com.interview.controller.form.PersonForm;
import br.com.interview.controller.form.SlotForm;
import br.com.interview.model.Person;
import br.com.interview.model.Slot;
import br.com.interview.model.Status;
import br.com.interview.model.TypeEnum;
import br.com.interview.service.PersonService;
import br.com.interview.service.SlotService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/interview")
public class InterviewController {

	@Autowired
	PersonService personService;	
	
	@Autowired
	SlotService slotService;
	
	@GetMapping
	public ResponseEntity<?> queryPossibleInterviews() {
		
		List<Slot> listSlot = slotService.findAll();
		
		//TODO
		
//		List<Slot> candidates = listSlot.stream()
//				.filter(s -> s.getPerson().getType() == TypeEnum.CANDIDATE)
//				//.filter(s -> LocalDate.now().isAfter(s.getInitDate()))
//				.collect(Collectors.toList());
//		List<Slot> interviewers = listSlot.stream().filter(s -> s.getPerson().getType() == TypeEnum.INTERVIEWER)
//				//.filter(s -> LocalDate.now().isAfter(s.getInitDate()))
//				.collect(Collectors.toList());
//		
//		Map<Slot, List<Slot>> mapCandidateIterview = new HashMap<>();
//		
//		candidates.stream().forEach(canditate -> {
//			List<Slot> interviewersAvalilable = interviewers.stream()
//					.filter(interviewer -> 
//						(canditate.getInitTime().isAfter(interviewer.getInitTime())	&& canditate.getEndTime().isBefore(interviewer.getEndTime()))
//						&& (canditate.getSlotDate().isEqual(interviewer.getSlotDate()) || canditate.getSlotDate().isAfter(interviewer.getSlotDate())))
//					.collect(Collectors.toList());
//			mapCandidateIterview.put(canditate, interviewersAvalilable);
//			//	
//
//		});
		
		
		
		//candidates.stream().filter(candidate ->  candidate)
			
		return ResponseEntity.ok().body(new SlotDto().converter(listSlot));
	}
	
	@PostMapping("/slot")
	@Transactional
	@ApiOperation(value = "Register slot by person",
    			  notes = "Endpoint responsible for register the slot time. First it checks whether the person exist, otherwise it returns http 422",
    			  response = SlotDto.class,
    			  responseContainer = "SlotDto")
	public ResponseEntity<SlotDto> registerSlot(@RequestBody @Valid SlotForm form, UriComponentsBuilder uriBuilder) {
		
		Optional<Person> personBd = personService.findById(form.getPersonId());
		
		if (personBd.isPresent()) {			
			Slot slot = new Slot(personBd.get(), 
					form.getSlotDate(), 
					form.getInitTime(), 
					form.getEndTime(),
					form.getRepeat(), 
					form.getRepeatEveryday(), 
					form.getRepeatEveryweek());
			slotService.save(slot);
			
			URI uri = uriBuilder.path("interview/slot/{id}").buildAndExpand(slot.getId()).toUri();

			return ResponseEntity.created(uri).body(new SlotDto(slot));
		}
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new SlotErrorDto(form.getPersonId(), "Person not registered in database"));
	}

	@PostMapping("/interviewer")
	@Transactional
	@ApiOperation(value = "Register interviewer",
	  notes = "Endpoint responsible for register the interviewer. First it checks whether the person exist, if not it is created and return http 201, otherwise, return http 200",
	  response = PersonDto.class,
	  responseContainer = "PersonDto")
	public ResponseEntity<?> registerInterviewer(@RequestBody @Valid PersonForm form,
			UriComponentsBuilder uriBuilder) {

		return register(form, TypeEnum.INTERVIEWER, uriBuilder);
	}

	@PostMapping("/candidate")
	@Transactional
	@ApiOperation(value = "Register candidate",
	  notes = "Endpoint responsible for register the candidate. First it checks whether the person exist, if not it is created and return http 201, otherwise, return http 200",
	  response = PersonDto.class,
	  responseContainer = "PersonDto")
	public ResponseEntity<?> registerCandidate(@RequestBody @Valid PersonForm form,
			UriComponentsBuilder uriBuilder) {

		return register(form, TypeEnum.CANDIDATE, uriBuilder);
	}

	/* Centralize the person creation, differing only person's type */
	private ResponseEntity<?> register(PersonForm form, TypeEnum typeEnum, UriComponentsBuilder uriBuilder) {
		Optional<Person> personDb = personService.findById(form.getId());
		if (!personDb.isPresent()) {

			Person person = new Person(form.getId(), form.getName(), typeEnum, LocalDateTime.now(), Status.ACTIVE);
			personService.save(person);

			URI uri = uriBuilder.path("interview/interviewer/{id}").buildAndExpand(person.getId()).toUri();

			return ResponseEntity.created(uri).body(new PersonDto(person));
		}
		return ResponseEntity.ok().body(new MessageDto("Person already register with id: " + form.getId()));
	}

}
