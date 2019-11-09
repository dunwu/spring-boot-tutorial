package io.github.dunwu.springboot.data;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface UserDao {

	void batchInsert(List<User> users);

	Integer count();

	void deleteByName(String name);

	void insert(User user);

	List<User> list();

	User queryByName(String name);

	void recreateTable();

	void update(User user);

	JdbcTemplate getJdbcTemplate();

}
