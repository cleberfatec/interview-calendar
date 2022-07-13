package br.com.interview;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.interview.controller.InterviewController;
import br.com.interview.controller.form.PersonForm;
import br.com.interview.controller.form.SlotForm;
import br.com.interview.model.Person;
import br.com.interview.model.Status;
import br.com.interview.model.TypeEnum;
import br.com.interview.repository.PersonRepository;
import br.com.interview.repository.SlotRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(InterviewController.class)
public class InterviewApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PersonRepository repository;
	
	@MockBean
	private SlotRepository scheduleRepository;

	@Test
	public void registerSlot_success() {
		String slotJson = "{\n" + 
				"	\"personId\": 1,\n" + 
				"	\"initTime\": \"13:00\",\n" + 
				"	\"endTime\": \"14:00\",\n" + 
				"	\"slotDate\": \"2022-07-23\",\n" + 
				"	\"repeat\": false,\n" + 
				"	\"repeatEveryday\" : false,\n" + 
				"	\"repeatEveryweek\" : false\n" + 
				"}\n" + 
				"";
		Optional<Person> person = Optional.of(new Person(1L, "test", TypeEnum.INTERVIEWER, LocalDateTime.now() , Status.ACTIVE));

        Mockito.when(repository.findById(Mockito.any(Long.class))).thenReturn(person);
        
		try {
			mvc.perform(post("/interview/slot")
					.contentType(MediaType.APPLICATION_JSON)
					.content(slotJson)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));		
											
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void registerSlot_unprocess() {
		SlotForm slotForm = new SlotForm();
		Optional<Person> person = Optional.empty();

        Mockito.when(repository.findById(Mockito.any(Long.class))).thenReturn(person);
        
		try {
			mvc.perform(post("/interview/slot")
					.contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(slotForm))
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isUnprocessableEntity())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));		
					
					
			;
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void registerInterviewer_success() {
		registerPerson("interviewer");
	}

	
	@Test
	public void registeCandidate_success() {
		registerPerson("candidate");
	}
	
	private void registerPerson(String personParam) {
		PersonForm personForm = new PersonForm(3000L, "test");
		Optional<Person> person = Optional.empty();

        Mockito.when(repository.findById(Mockito.any(Long.class))).thenReturn(person);
        
		try {
			mvc.perform(post("/interview/".concat(personParam))
					.contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(personForm))
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
			;
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
