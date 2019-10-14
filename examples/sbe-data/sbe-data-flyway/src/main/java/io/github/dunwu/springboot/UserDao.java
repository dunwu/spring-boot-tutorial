package io.github.dunwu.springboot;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface UserDao {

	JdbcTemplate getJdbcTemplate();

	void recreateTable();

	void batchInsert(List<User> users);

	void insert(User user);

	void deleteByName(String name);

	void update(User user);

	Integer count();

	User queryByName(String name);

	List<User> list();

}
