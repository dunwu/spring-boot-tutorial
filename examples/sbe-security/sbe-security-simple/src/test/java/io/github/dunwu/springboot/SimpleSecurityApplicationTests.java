package io.github.dunwu.springboot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SimpleSecurityApplication.class})
public class SimpleSecurityApplicationTests {

	@Autowired
	private SampleService service;

	private Authentication authentication;

	@Before
	public void init() {
		this.authentication = new UsernamePasswordAuthenticationToken("root", "root");
	}

	@After
	public void close() {
		SecurityContextHolder.clearContext();
	}

	@Test
	public void secure() {
		assertThatExceptionOfType(AuthenticationException.class)
			.isThrownBy(() -> SimpleSecurityApplicationTests.this.service.secure());
	}

	@Test
	public void authenticated() {
		SecurityContextHolder.getContext().setAuthentication(this.authentication);
		assertThat("Hello Security").isEqualTo(this.service.secure());
	}

	@Test
	public void preauth() {
		SecurityContextHolder.getContext().setAuthentication(this.authentication);
		assertThat("Hello World").isEqualTo(this.service.authorized());
	}

	@Test
	public void denied() {
		SecurityContextHolder.getContext().setAuthentication(this.authentication);
		assertThatExceptionOfType(AccessDeniedException.class)
			.isThrownBy(() -> SimpleSecurityApplicationTests.this.service.denied());
	}

}
