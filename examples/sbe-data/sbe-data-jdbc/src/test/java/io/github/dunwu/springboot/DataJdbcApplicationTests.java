package io.github.dunwu.springboot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DataJdbcApplication.class })
public class DataJdbcApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(DataJdbcApplicationTests.class);

	@Autowired
	private UserDAO userDAO;

	@Before
	public void before() {
		userDAO.recreateTable();
	}

	@Test
	public void batchInsert() {
		List<User> users = new ArrayList<>();
		users.add(new User("Jack", 18));
		users.add(new User("Tom", 19));
		users.add(new User("Jone", 28));
		users.add(new User("Bill", 20));
		userDAO.batchInsert(users);
		int count = userDAO.count();
		Assert.assertEquals(4, count);

		List<User> list = userDAO.list();
		Assert.assertNotNull(list);
		Assert.assertEquals(4, list.size());
		list.forEach(user -> {
			log.info(user.toString());
		});
	}

	@Test
	public void insert() {
		userDAO.insert("Linda", 19);
		User linda = userDAO.queryByName("Linda");
		Assert.assertNotNull(linda);
	}

	@Test
	public void delete() {
		userDAO.insert("Linda", 19);
		userDAO.delete("Linda");
		User linda = userDAO.queryByName("Linda");
		Assert.assertNull(linda);
	}

	@Test
	public void update() {
		userDAO.insert("Linda", 19);
		User linda = userDAO.queryByName("Linda");
		linda.setName("Jack");
		userDAO.update(linda);
		User jack = userDAO.queryByName("Jack");
		Assert.assertNotNull(jack);
	}

}
