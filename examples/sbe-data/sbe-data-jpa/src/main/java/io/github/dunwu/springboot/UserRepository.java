package io.github.dunwu.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByName(String name);

	User findByNameAndAge(String name, Integer age);

	@Query("from User u where u.name=:name")
	User findUser(@Param("name") String name);

}
