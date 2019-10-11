package io.github.dunwu.springboot.service.impl;

import io.github.dunwu.springboot.entity.UserDO;
import io.github.dunwu.springboot.repository.UserRepository;
import io.github.dunwu.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void insert(UserDO userDO) {
		String username = userDO.getUsername();
		if (exist(username)) {
			throw new RuntimeException("用户名已存在！");
		}
		userRepository.save(userDO);
	}

	@Override
	public UserDO getByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	/**
	 * 判断用户是否存在
	 */
	private boolean exist(String username) {
		UserDO userDO = userRepository.findByUsername(username);
		return (userDO != null);
	}

}
