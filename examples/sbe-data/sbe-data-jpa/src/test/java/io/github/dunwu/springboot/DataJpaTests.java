package io.github.dunwu.springboot;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DataJpaTest
@ActiveProfiles({ "test" })
@RunWith(SpringRunner.class)
public class DataJpaTests {

	@Autowired
	private UserRepository repository;

	@Before
	public void before() {
		repository.deleteAll();
	}

	@Test
	public void add() {
		repository.save(new User("张三", 21, "南京", "xxx@163.com"));
		repository.save(new User("李四", 28, "上海", "xxx@163.com"));
		repository.save(new User("王五", 24, "北京", "xxx@163.com"));
		repository.save(new User("赵六", 31, "广州", "xxx@163.com"));
		Assert.assertEquals(4L, repository.count());

		List<User> users = repository.findAll();
		Assert.assertEquals(4, users.size());

		System.out.println("user list: ");
		users.forEach(System.out::println);
	}

	@Test
	public void delete() {
		User user = repository.save(new User("张三", 21, "南京", "xxx@163.com"));
		Optional<User> userOptional = repository.findByName(user.getName());
		Assert.assertNotNull(userOptional);
		Assert.assertNotNull(userOptional.get());

		repository.delete(user);
		Optional<User> result2 = repository.findByName(user.getName());
		if (result2.isPresent()) {
			Assert.fail();
		}
	}

	@Test
	public void update() {
		User lisi = repository.save(new User("李四", 28, "上海", "xxx@163.com"));
		System.out.println("Origin User: " + lisi.toString());

		lisi.setName("lisi");
		repository.save(lisi);

		User result = repository.findUser("lisi");
		Assert.assertNotNull(result);
		System.out.println("Updated User: " + result.toString());
	}

	@Test
	public void findAll() {
		repository.save(new User("张三", 21, "南京", "xxx@163.com"));
		repository.save(new User("李四", 28, "上海", "xxx@163.com"));
		repository.save(new User("王五", 24, "北京", "xxx@163.com"));
		repository.save(new User("赵六", 31, "广州", "xxx@163.com"));

		List<User> users = repository.findAll();
		if (CollectionUtils.isEmpty(users) || users.size() != 4) {
			Assert.fail();
		}
		else {
			System.out.println("user list: ");
			users.forEach(System.out::println);
		}
	}

	@Test
	public void findAllInPage() {
		repository.save(new User("张三", 21, "南京", "xxx@163.com"));
		repository.save(new User("李四", 28, "上海", "xxx@163.com"));
		repository.save(new User("王五", 24, "北京", "xxx@163.com"));
		repository.save(new User("赵六", 31, "广州", "xxx@163.com"));

		PageRequest pageRequest = PageRequest.of(1, 2);
		Page<User> page = repository.findAll(pageRequest);
		if (page.isEmpty()) {
			Assert.fail();
		}
		else {
			page.getTotalElements();
			Assert.assertEquals(4, page.getTotalElements());
			Assert.assertEquals(2, page.getTotalPages());
			List<User> users = page.get().collect(Collectors.toList());
			System.out.println("user list: ");
			users.forEach(System.out::println);
		}
	}

}
