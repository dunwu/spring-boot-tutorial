package io.github.dunwu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019-08-19
 */
@RestController
@RequestMapping("redis")
public class RedicController {

	@Autowired
	private final StringRedisTemplate redisTemplate;

	private final ValueOperations<String, String> valueOperations;

	private final HashOperations<String, Object, Object> hashOperations;

	private final ListOperations<String, String> listOperations;

	private final SetOperations<String, String> setOperations;

	private final ZSetOperations<String, String> zsetOperations;

	public RedicController(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.valueOperations = redisTemplate.opsForValue();
		this.listOperations = redisTemplate.opsForList();
		this.setOperations = redisTemplate.opsForSet();
		this.hashOperations = redisTemplate.opsForHash();
		this.zsetOperations = redisTemplate.opsForZSet();
	}

	@GetMapping("getString")
	public String getString(String key) {
		String result = valueOperations.get(key);
		return result;
	}

	@PostMapping("setString")
	public void setString(Map<String, Object> map) {
		String key = (String) map.get("key");
		Object value = map.get("value");

		if (value instanceof String) {
			String val = (String) value;
			valueOperations.set(key, val);
		}
	}

	@PostMapping("deleteKey")
	public void deleteKey(String key) {
		redisTemplate.delete(key);
	}

}
