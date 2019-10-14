package io.github.dunwu.springboot.mapper;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import io.github.dunwu.springboot.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface UserDao {

	JdbcTemplate getJdbcTemplate();

	void recreateTable();

	void batchInsert(List<User> users);

	void insert(User user);

	@CacheInvalidate(name = "dunwu:users-", key = "#name")
	int deleteByName(String name);

	@CacheUpdate(name = "dunwu:users-", key = "#user.name", value = "#user")
	User update(User user);

	Integer count();

	@Cached(name = "dunwu:users-", key = "#name", expire = 3600)
	User queryByName(String name);

	List<User> list();

}
