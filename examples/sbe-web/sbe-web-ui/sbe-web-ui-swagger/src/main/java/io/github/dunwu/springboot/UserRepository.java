package io.github.dunwu.springboot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface UserRepository
	extends CrudRepository<User, Long>, PagingAndSortingRepository<User, Long>, QueryByExampleExecutor<User> {

	Optional<User> findByName(String name);

}
