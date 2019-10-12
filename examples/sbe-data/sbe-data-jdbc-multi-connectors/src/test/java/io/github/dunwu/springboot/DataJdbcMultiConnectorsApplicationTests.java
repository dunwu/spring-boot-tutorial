package io.github.dunwu.springboot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DataJdbcMultiConnectorsApplicationTests {

	@Autowired
	@Qualifier("mysqlUserDao")
	private UserDao mysqlUserDao;

	@Autowired
	@Qualifier("h2UserDao")
	private UserDao h2UserDao;

	@Before
	public void before() {
		mysqlUserDao.recreateTable();
		h2UserDao.recreateTable();
	}

	@Test
	public void test() {

		// 向主数据源插入记录
		mysqlUserDao.insert(new User("张三", 21, "南京", "xxx@163.com"));
		mysqlUserDao.insert(new User("李四", 28, "上海", "xxx@163.com"));
		mysqlUserDao.insert(new User("王五", 24, "北京", "xxx@163.com"));
		mysqlUserDao.insert(new User("赵六", 31, "广州", "xxx@163.com"));

		// 验证主数据源插入记录数正确
		int count = mysqlUserDao.count();
		Assert.assertEquals(4, count);

		// 向次数据源插入记录
		h2UserDao.insert(new User("张三", 21, "南京", "xxx@163.com"));

		// 验证次数据源插入记录数正确
		count = h2UserDao.count();
		Assert.assertEquals(1, count);

	}

}
