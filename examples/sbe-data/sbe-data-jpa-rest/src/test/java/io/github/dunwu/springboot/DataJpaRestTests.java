package io.github.dunwu.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
@RunWith(SpringRunner.class)
public class DataJpaRestTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Before
	public void deleteAllBeforeTests() throws Exception {
		userRepository.deleteAll();
	}

	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$._links.user").exists());
	}

	@Test
	public void shouldCreateEntity() throws Exception {

		User user = new User("王五", 21, "南京", "xxx@163.com");
		mockMvc.perform(post("/user").content(objectMapper.writeValueAsString(user)))
			   .andExpect(status().isCreated())
			   .andExpect(header().string("Location", containsString("user/")));
	}

	@Test
	public void shouldRetrieveEntity() throws Exception {

		User user = new User("赵六", 21, "广州", "xxx@163.com");
		MvcResult mvcResult = mockMvc.perform(post("/user").content(objectMapper.writeValueAsString(user)))
									 .andExpect(status().isCreated())
									 .andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location))
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$.name").value("赵六"))
			   .andExpect(jsonPath("$.address").value("广州"));
	}

	@Test
	public void shouldQueryEntity() throws Exception {

		User user = new User("赵六", 21, "广州", "xxx@163.com");
		mockMvc.perform(post("/user").content(objectMapper.writeValueAsString(user))).andExpect(status().isCreated());

		mockMvc.perform(get("/user/search/findByName?name={name}", "赵六")).andExpect(status().isOk());
	}

	@Test
	public void shouldUpdateEntity() throws Exception {

		User user = new User("张三", 18, "北京", "xxx@163.com");
		User user2 = new User("李四", 19, "上海", "xxx@163.com");
		MvcResult mvcResult = mockMvc.perform(post("/user").content(objectMapper.writeValueAsString(user)))
									 .andExpect(status().isCreated())
									 .andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(put(location).content(objectMapper.writeValueAsString(user2)))
			   .andExpect(status().isNoContent());

		mockMvc.perform(get(location))
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$.name").value("李四"))
			   .andExpect(jsonPath("$.age").value(19));
	}

	@Test
	public void shouldPartiallyUpdateEntity() throws Exception {

		User user = new User("张三", 18, "北京", "xxx@163.com");
		User user2 = new User("李四", 19, "上海", "xxx@163.com");

		MvcResult mvcResult = mockMvc.perform(post("/user").content(objectMapper.writeValueAsString(user)))
									 .andExpect(status().isCreated())
									 .andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(patch(location).content(objectMapper.writeValueAsString(user2)))
			   .andExpect(status().isNoContent());

		mockMvc.perform(get(location))
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$.name").value("李四"))
			   .andExpect(jsonPath("$.age").value(19));
	}

	@Test
	public void shouldDeleteEntity() throws Exception {

		User user = new User("张三", 18, "北京", "xxx@163.com");
		MvcResult mvcResult = mockMvc.perform(post("/user").content(objectMapper.writeValueAsString(user)))
									 .andExpect(status().isCreated())
									 .andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}

}
