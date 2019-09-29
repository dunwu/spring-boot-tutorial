package io.github.dunwu.springboot.security.config;

import io.github.dunwu.springboot.security.handler.CustomAuthenticationFailureHandler;
import io.github.dunwu.springboot.security.handler.CustomAuthenticationSucessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationSucessHandler authenticationSucessHandler;

	@Autowired
	private CustomAuthenticationFailureHandler authenticationFailureHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin() // 表单登录
				// http.httpBasic() // HTTP Basic
				.loginPage("/authentication/require") // 登录跳转 URL
				.loginProcessingUrl("/login") // 处理表单登录 URL
				.successHandler(authenticationSucessHandler) // 处理登录成功
				.failureHandler(authenticationFailureHandler) // 处理登录失败
				.and().authorizeRequests() // 授权配置
				.antMatchers("/authentication/require", "/login.html").permitAll() // 登录跳转
																					// URL
																					// 无需认证
				.anyRequest() // 所有请求
				.authenticated() // 都需要认证
				.and().csrf().disable();
	}

}
