package io.github.dunwu.springboot;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface UserDao {

	JdbcTemplate getJdbcTemplate();

	void recreateTable();

	void batchInsert(List<User> users);

	void insert(User user);

	@CacheEvict(value = "dunwu:users", key = "#name")
	int deleteByName(String name);

	@CachePut(value = "dunwu:users", key = "#user.name")
	User update(User user);

	Integer count();

	@Cacheable(value = "dunwu:users", key = "#name")
	User queryByName(String name);

	List<User> list();

}
