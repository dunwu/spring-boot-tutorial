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
@Service("mysqlUserDao")
public class MysqlUserDaoImpl implements UserDao {

	private final JdbcTemplate jdbcTemplate;

	public MysqlUserDaoImpl(@Qualifier("primaryJdbcTemplate") JdbcTemplate jdbcTemplate) {
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
			"CREATE TABLE user (\n" + "    id      BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Id',\n"
				+ "    name    VARCHAR(10)         NOT NULL DEFAULT '' COMMENT '用户名',\n"
				+ "    age     TINYINT(3)          NOT NULL DEFAULT 0 COMMENT '年龄',\n"
				+ "    address VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '地址',\n"
				+ "    email   VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '邮件',\n" + "    PRIMARY KEY (id)\n"
				+ ") COMMENT = '用户表';";
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
