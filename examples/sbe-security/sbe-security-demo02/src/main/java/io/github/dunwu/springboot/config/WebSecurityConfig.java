package io.github.dunwu.springboot.config;

import io.github.dunwu.springboot.service.impl.DbUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private DbUserDetailsServiceImpl dbUserDetailsService;

	@Autowired
	public void setAnyUserDetailsService(DbUserDetailsServiceImpl dbUserDetailsService) {
		this.dbUserDetailsService = dbUserDetailsService;
	}

	/**
	 * 添加 UserDetailsService， 实现自定义登录校验
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(dbUserDetailsService);
	}

	/**
	 * 匹配 "/" 路径，不需要权限即可访问 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限 登录地址为 "/login"，登录成功默认跳转到页面
	 * "/user" 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login" 默认启用 CSRF
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/user/**").hasAuthority("USER").and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/user").and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/login");
	}

	// /**
	// * 密码不加密
	// */
	// @Bean
	// public static PasswordEncoder passwordEncoder( ){
	// DelegatingPasswordEncoder delegatingPasswordEncoder =
	// (DelegatingPasswordEncoder)
	// PasswordEncoderFactories.createDelegatingPasswordEncoder();
	// //设置defaultPasswordEncoderForMatches为NoOpPasswordEncoder
	// delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(NoOpPasswordEncoder.getInstance());
	// return delegatingPasswordEncoder;
	// }

	/**
	 * 密码加密
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
