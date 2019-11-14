package io.github.dunwu.springboot.security.config;

import io.github.dunwu.springboot.security.domain.MyUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final PasswordEncoder passwordEncoder;

	public UserDetailServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 模拟一个用户，替代数据库获取逻辑
		MyUser user = new MyUser();
		user.setUserName(username).setPassword(this.passwordEncoder.encode("123456"));
		// 输出加密后的密码
		log.info("加密后的密码：" + user.getPassword());
		return new User(username, user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
			user.isCredentialsNonExpired(), user.isAccountNonLocked(),
			AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}
