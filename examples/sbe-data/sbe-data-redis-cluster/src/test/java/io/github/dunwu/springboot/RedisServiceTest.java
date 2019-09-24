package io.github.dunwu.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019-08-22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisServiceTest {

	@Autowired
	private StringRedisTemplate redisTemplate;

	private ValueOperations<String, String> valueOperations;

	private HashOperations<String, Object, Object> hashOperations;

	private ListOperations<String, String> listOperations;

	private SetOperations<String, String> setOperations;

	private ZSetOperations<String, String> zsetOperations;

	@Before
	public void before() {
		this.valueOperations = redisTemplate.opsForValue();
		this.listOperations = redisTemplate.opsForList();
		this.setOperations = redisTemplate.opsForSet();
		this.hashOperations = redisTemplate.opsForHash();
		this.zsetOperations = redisTemplate.opsForZSet();
	}

	public StringRedisTemplate getRedisTemplate() {
		return this.redisTemplate;
	}

	@Test
	public void testStringGetSet() {
		for (int i = 0; i < 10; i++) {
			valueOperations.set("zptest" + i, new Date().toString());
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(valueOperations.get("zptest" + i));
		}
	}

}
