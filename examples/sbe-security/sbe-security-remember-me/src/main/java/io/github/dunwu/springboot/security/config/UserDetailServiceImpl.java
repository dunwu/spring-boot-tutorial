package io.github.dunwu.springboot.security.config;

import io.github.dunwu.springboot.security.domain.User;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private final PasswordEncoder passwordEncoder;

	public UserDetailServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 模拟一个用户，替代数据库获取逻辑
		User user = new User();
		user.setUserName(username);
		user.setPassword(this.passwordEncoder.encode("123456"));
		// 输出加密后的密码
		System.out.println("加密后的密码：" + user.getPassword());

		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.isEnabled(),
			user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(),
			AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}
