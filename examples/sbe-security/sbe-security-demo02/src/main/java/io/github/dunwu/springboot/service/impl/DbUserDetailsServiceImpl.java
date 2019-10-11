package io.github.dunwu.springboot.service.impl;

import io.github.dunwu.springboot.entity.UserDO;
import io.github.dunwu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019-06-09
 */
@Service
public class DbUserDetailsServiceImpl implements UserDetailsService {

	private final UserService userService;

	@Autowired
	DbUserDetailsServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDO userDO = userService.getByUsername(username);
		if (userDO == null) {
			throw new UsernameNotFoundException("用户不存在！");
		}
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
		simpleGrantedAuthorities.add(new SimpleGrantedAuthority("USER"));
		return new User(userDO.getUsername(), userDO.getPassword(), simpleGrantedAuthorities);
	}

}
