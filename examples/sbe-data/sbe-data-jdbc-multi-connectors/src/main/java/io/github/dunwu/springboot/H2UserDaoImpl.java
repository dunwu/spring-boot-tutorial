package io.github.dunwu.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019/10/12
 */
@Service("h2UserDao")
public class H2UserDaoImpl implements UserDao {

	private final JdbcTemplate jdbcTemplate;

	public H2UserDaoImpl(@Qualifier("secondaryJdbcTemplate") JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void recreateTable() {
		jdbcTemplate.execute("DROP TABLE IF EXISTS user");

		String sqlStatement =
			"CREATE TABLE IF NOT EXISTS user (\n" + "    id      INT IDENTITY NOT NULL COMMENT '主键ID',\n"
				+ "    name    VARCHAR(30)  NOT NULL COMMENT '姓名',\n"
				+ "    age     INT          NULL DEFAULT 0 COMMENT '年龄',\n"
				+ "    address VARCHAR(50)  NULL DEFAULT '' COMMENT '地址',\n"
				+ "    email   VARCHAR(50)  NULL DEFAULT '' COMMENT '邮箱',\n" + "    PRIMARY KEY (id)\n" + ")";
		jdbcTemplate.execute(sqlStatement);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void batchInsert(List<User> users) {
		String sql = "INSERT INTO user(name, age, address, email) VALUES(?, ?, ?, ?)";

		List<Object[]> params = new ArrayList<>();

		users.forEach(item -> {
			params.add(new Object[] {item.getName(), item.getAge(), item.getAddress(), item.getEmail()});
		});
		jdbcTemplate.batchUpdate(sql, params);
	}

	@Override
	public void insert(User user) {
		jdbcTemplate.update("INSERT INTO user(name, age, address, email) VALUES(?, ?, ?, ?)", user.getName(),
							user.getAge(), user.getAddress(), user.getEmail());
	}

	@Override
	public void deleteByName(String name) {
		jdbcTemplate.update("DELETE FROM user WHERE name = ?", name);
	}

	@Override
	public void update(User user) {
		jdbcTemplate.update("UPDATE USER SET name=?, age=?, address=?, email=? WHERE id=?", user.getName(),
							user.getAge(), user.getAddress(), user.getEmail(), user.getId());
	}

	@Override
	public Integer count() {
		try {
			return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public User queryByName(String name) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM user WHERE name = ?",
											   new BeanPropertyRowMapper<>(User.class), name);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<User> list() {
		return jdbcTemplate.query("select * from USER", new BeanPropertyRowMapper(User.class));
	}

}
