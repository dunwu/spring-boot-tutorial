package io.github.dunwu.springboot;

import io.github.dunwu.springboot.data.User;
import io.github.dunwu.springboot.data.UserDao;
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
@SpringBootTest(classes = { SpringBootDataJdbcApplication.class })
public class SpringBootDataJdbcApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SpringBootDataJdbcApplicationTests.class);

	@Autowired
	private UserDao userDAO;

	@Test
	public void batchInsert() {
		List<User> users = new ArrayList<>();
		users.add(new User("张三", 21, "南京", "xxx@163.com"));
		users.add(new User("李四", 28, "上海", "xxx@163.com"));
		users.add(new User("王五", 24, "北京", "xxx@163.com"));
		users.add(new User("赵六", 31, "广州", "xxx@163.com"));

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

	@Before
	public void before() {
		userDAO.recreateTable();
	}

	@Test
	public void delete() {
		userDAO.insert(new User("张三", 21, "南京", "xxx@163.com"));
		userDAO.deleteByName("张三");
		User zhangsan = userDAO.queryByName("张三");
		Assert.assertNull(zhangsan);
	}

	@Test
	public void insert() {
		userDAO.insert(new User("张三", 21, "南京", "xxx@163.com"));
		User linda = userDAO.queryByName("张三");
		Assert.assertNotNull(linda);
	}

	@Test
	public void update() {
		userDAO.insert(new User("张三", 21, "南京", "xxx@163.com"));
		User zhangsan = userDAO.queryByName("张三");
		zhangsan.setName("张三丰");
		userDAO.update(zhangsan);
		User jack = userDAO.queryByName("张三丰");
		Assert.assertNotNull(jack);
	}

}
