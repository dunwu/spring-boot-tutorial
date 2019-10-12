package io.github.dunwu.springboot;

import io.github.dunwu.springboot.entity.User;
import io.github.dunwu.springboot.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@ActiveProfiles({"test"})
@RunWith(SpringRunner.class)
public class DataOrmMybatisApplicationTest {

	@Resource
	private UserMapper userMapper;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		Assert.assertEquals(2, userList.size());
		userList.forEach(System.out::println);
	}

}
