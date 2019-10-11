package io.github.dunwu.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DataJpaRestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PersonRepository personRepository;

	@Before
	public void deleteAllBeforeTests() throws Exception {
		personRepository.deleteAll();
	}

	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$._links.people").exists());
	}

	@Test
	public void shouldCreateEntity() throws Exception {

		mockMvc.perform(post("/people").content("{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}"))
				.andExpect(status().isCreated()).andExpect(header().string("Location", containsString("people/")));
	}

	@Test
	public void shouldRetrieveEntity() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(post("/people").content("{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}"))
				.andExpect(status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(jsonPath("$.firstName").value("Frodo"))
				.andExpect(jsonPath("$.lastName").value("Baggins"));
	}

	@Test
	public void shouldQueryEntity() throws Exception {

		mockMvc.perform(post("/people").content("{ \"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}"))
				.andExpect(status().isCreated());

		mockMvc.perform(get("/people/search/findByLastName?name={name}", "Baggins")).andExpect(status().isOk())
				.andExpect(jsonPath("$._embedded.people[0].firstName").value("Frodo"));
	}

	@Test
	public void shouldUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(post("/people").content("{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}"))
				.andExpect(status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(put(location).content("{\"firstName\": \"Bilbo\", \"lastName\":\"Baggins\"}"))
				.andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(jsonPath("$.firstName").value("Bilbo"))
				.andExpect(jsonPath("$.lastName").value("Baggins"));
	}

	@Test
	public void shouldPartiallyUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(post("/people").content("{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}"))
				.andExpect(status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(patch(location).content("{\"firstName\": \"Bilbo Jr.\"}")).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(jsonPath("$.firstName").value("Bilbo Jr."))
				.andExpect(jsonPath("$.lastName").value("Baggins"));
	}

	@Test
	public void shouldDeleteEntity() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(post("/people").content("{ \"firstName\": \"Bilbo\", \"lastName\":\"Baggins\"}"))
				.andExpect(status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}

}
