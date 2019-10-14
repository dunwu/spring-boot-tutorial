package io.github.dunwu.springboot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
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
public interface UserRepository
	extends CrudRepository<User, Long>, PagingAndSortingRepository<User, Long>, QueryByExampleExecutor<User> {

	/**
	 * 查询接口
	 * <p>
	 * 示例：http://localhost:8080/user/search/findByName?name=lisi
	 * @param name 姓名
	 * @return
	 */
	Optional<User> findByName(@Param("name") String name);

}
