package io.github.dunwu.springboot;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019/10/14
 */
public interface UserService {

	void setUser(User user);

	User getUser(Long id);

}
