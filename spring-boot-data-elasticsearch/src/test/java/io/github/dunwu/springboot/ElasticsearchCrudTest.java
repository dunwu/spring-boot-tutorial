package io.github.dunwu.springboot;

import io.github.dunwu.springboot.data.User;
import io.github.dunwu.springboot.data.UserRepository;
import io.github.dunwu.util.RandomExtUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootDataElasticsearchApplication.class })
public class ElasticsearchCrudTest {

	@Autowired
	private UserRepository userRepository;

	@Before
	public void before() {
		userRepository.deleteAll();

		userRepository.save(new User("张鹏", "xxxxxx", "forbreak@163.com"));
		userRepository.save(new User("张鹏", "xxxxxx", "xxxxxxx@163.com"));
	}

	@Test
	public void testCount() {
		long count = userRepository.count();
		assertThat(count).isEqualTo(2L);
	}

	@Test
	public void testSave() {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			User user = new User(RandomExtUtils.randomChineseName(), RandomExtUtils.randomLetter(6, 10),
				RandomExtUtils.randomEmail());
			users.add(user);
		}
		userRepository.saveAll(users);
		long count = userRepository.count();
		assertThat(count).isEqualTo(1002L);
	}

	@Test
	public void testFind() {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			User user = new User(RandomExtUtils.randomChineseName(), RandomExtUtils.randomLetter(6, 10),
				RandomExtUtils.randomEmail());
			users.add(user);
		}
		userRepository.saveAll(users);

		Iterable<User> userList = userRepository.findAll();
		userList.forEach(System.out::println);

		System.out.println("User found with findByUsername(\"张鹏\"):");
		System.out.println("--------------------------------");
		List<User> userList2 = userRepository.findByUsername("鹏");
		assertThat(userList2).isNotEmpty();
		userList2.forEach(System.out::println);

		System.out.println("Users found with findByEmail(\"forbreak@163.com\"):");
		System.out.println("--------------------------------");
		User user = userRepository.findByEmail("forbreak@163.com");
		System.out.println(user);
		assertThat(user).isNotNull();
	}

	@Test
	public void testUpdate() {
		User user = userRepository.findByEmail("forbreak@163.com");
		System.out.println("Before Update: " + user);
		assertThat(user).isNotNull();

		user.setEmail("modify@modify.com");
		userRepository.deleteById(user.getId());
		userRepository.save(user);
		Optional<User> optional = userRepository.findById(user.getId());
		assertThat(optional).isNotNull();
		assertThat(optional.get().getEmail()).isEqualTo("modify@modify.com");
		assertThat(optional.get().getId()).isEqualTo(user.getId());
		System.out.println("After Update: " + optional.get());
	}

}
