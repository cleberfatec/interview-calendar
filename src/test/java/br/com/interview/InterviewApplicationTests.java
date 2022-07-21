package br.com.interview;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.interview.controller.InterviewController;
import br.com.interview.controller.form.PersonForm;
import br.com.interview.model.Candidate;
import br.com.interview.model.Interviewer;
import br.com.interview.model.Status;
import br.com.interview.service.CandidateService;
import br.com.interview.service.InterviewerService;

@RunWith(SpringRunner.class)
@WebMvcTest(InterviewController.class)
public class InterviewApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CandidateService candidateService;
	
	@MockBean
	private InterviewerService interviewerService;


	@Test
	public void getPossibleInterviews() {

		Optional<Candidate> candidate1 = Optional.of(new Candidate(1L, "candidate", LocalDateTime.now(), LocalDate.now(), LocalTime.of(11, 00), LocalTime.of(12, 00) , Status.ACTIVE));
		Optional<Candidate> candidate2 = Optional.of(new Candidate(1L, "candidate", LocalDateTime.now(), LocalDate.now(), LocalTime.of(10, 00), LocalTime.of(11, 00) , Status.ACTIVE));
		
		Optional<Interviewer> interviewer = Optional.of(new Interviewer(1L, "interviewer", LocalDateTime.now(), LocalDate.now(), LocalTime.of(9, 00), LocalTime.of(10, 00) , Status.ACTIVE));

		
		List<Candidate> listCandidate = new ArrayList<>();
		listCandidate.add(candidate1.get());
		listCandidate.add(candidate2.get());
		
		List<Interviewer> listInterview = new ArrayList<>();
		listInterview.add(interviewer.get());		
        
		when(candidateService.findAll()).thenReturn(listCandidate);        
        when(interviewerService.findAll()).thenReturn(listInterview);
        
		try {
			mvc.perform(get("/interview")
					.contentType(MediaType.APPLICATION_JSON)					
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));		
											
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void registerInterviewer_success() {
		PersonForm personForm = new PersonForm(3000L, "interviewer", LocalDate.now(), LocalTime.now(), LocalTime.now());
		Optional<Interviewer> person = Optional.empty();

        when(interviewerService.findById(any(Long.class))).thenReturn(person);                        

		try {
			mvc.perform(post("/interview/".concat("interviewer"))
					.contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(personForm))
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isBadRequest());
			;
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	
	@Test
	public void registeCandidate_success() {
		PersonForm personForm = new PersonForm(3000L, "candidate", LocalDate.now(), LocalTime.now(), LocalTime.now());
		Optional<Candidate> person = Optional.empty();
        
        when(candidateService.findById(any(Long.class))).thenReturn(person);                        
        
		try {
			mvc.perform(post("/interview/".concat("candidate"))
					.contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(personForm))
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isBadRequest());
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    


}
