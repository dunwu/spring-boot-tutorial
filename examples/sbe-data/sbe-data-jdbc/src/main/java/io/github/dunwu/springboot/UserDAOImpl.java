package io.github.dunwu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Transactional
	public void recreateTable() {
		jdbcTemplate.execute("DROP DATABASE IF EXISTS test");
		jdbcTemplate.execute("CREATE DATABASE test");
		jdbcTemplate.execute("USE test");
		jdbcTemplate.execute("DROP TABLE if EXISTS user");
		jdbcTemplate.execute("DROP TABLE if EXISTS user");
		// @formatter:off
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE user (id int (10) unsigned NOT NULL AUTO_INCREMENT,\n")
          .append("name varchar (64) NOT NULL DEFAULT '',\n")
          .append("age tinyint (3) NOT NULL DEFAULT 0,\n")
          .append("PRIMARY KEY (ID));\n");
        // @formatter:on
		jdbcTemplate.execute(sb.toString());
	}

	@Override
	public void batchInsert(List<User> users) {
		String sql = "INSERT INTO user(name, age) VALUES(?, ?)";

		List<Object[]> params = new ArrayList<>();

		users.forEach(item -> {
			params.add(new Object[] { item.getName(), item.getAge() });
		});
		jdbcTemplate.batchUpdate(sql, params);
	}

	@Override
	public void insert(String name, Integer age) {
		jdbcTemplate.update("INSERT INTO user(name, age) VALUES(?, ?)", name, age);
	}

	@Override
	public void delete(String name) {
		jdbcTemplate.update("DELETE FROM user WHERE name = ?", name);
	}

	@Override
	public void update(User user) {
		jdbcTemplate.update("UPDATE USER SET name=?, age=? WHERE id=?", user.getName(),
				user.getAge(), user.getId());
	}

	@Override
	public Integer count() {
		try {
			return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user",
					Integer.class);
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public User queryByName(String name) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM user WHERE name = ?",
					new BeanPropertyRowMapper<>(User.class), name);
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<User> list() {
		return jdbcTemplate.query("select * from USER",
				new BeanPropertyRowMapper(User.class));
	}

}
