package io.github.dunwu.springboot.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * JPA Rest 接口示例
 * <p>
 * 启动 Application 后，直接访问：http://<host:ip>/user
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019/10/12
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * 查询接口
	 * <p>
	 * 示例：http://localhost:8080/user/search/findByName?name=lisi
	 *
	 * @param name 姓名
	 * @return Optional<User>
	 */
	Optional<User> findByName(@Param("name") String name);

	@Query("from User u where u.name=:name")
	User findUser(@Param("name") String name);

}
