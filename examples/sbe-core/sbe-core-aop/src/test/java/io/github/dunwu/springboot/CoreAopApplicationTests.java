package io.github.dunwu.springboot;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

public class CoreAopApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testDefaultSettings() {
		CoreAopApplication.main(new String[0]);
		String output = this.outputCapture.toString();

		// @formatter:off
		// tag::config[]
		assertThat(output).contains(
			"call @Before, joinPoint: execution(String io.github.dunwu.springboot.service.HelloWorldService.getHelloMessage())");
		assertThat(output).contains(
			"call @After, joinPoint: execution(String io.github.dunwu.springboot.service.HelloWorldService.getHelloMessage())");
		assertThat(output).contains(
			"call @AfterReturning, joinPoint: execution(String io.github.dunwu.springboot.service.HelloWorldService.getHelloMessage())");
		assertThat(output).contains("Hello Zhang Peng");
		// end::config[]
		// @formatter:on
	}

	@Test
	public void testCommandLineOverrides() {
		CoreAopApplication.main(new String[] {"--author.name=Spring Boot"});
		String output = this.outputCapture.toString();

		// @formatter:off
		// tag::config[]
		assertThat(output).contains(
			"call @Before, joinPoint: execution(String io.github.dunwu.springboot.service.HelloWorldService.getHelloMessage())");
		assertThat(output).contains(
			"call @After, joinPoint: execution(String io.github.dunwu.springboot.service.HelloWorldService.getHelloMessage())");
		assertThat(output).contains(
			"call @AfterReturning, joinPoint: execution(String io.github.dunwu.springboot.service.HelloWorldService.getHelloMessage())");
		assertThat(output).contains("Hello Spring Boot");
		// end::config[]
		// @formatter:on
	}

	@Test(expected = Exception.class)
	public void testFailture() {
		CoreAopApplication.main(new String[] {"--throw.exception=true"});
		String output = this.outputCapture.toString();

		// @formatter:off
		// tag::config[]
		assertThat(output).contains(
			"call @Before, joinPoint: execution(void io.github.dunwu.springboot.service.HelloWorldService.getException())");
		assertThat(output).contains(
			"call @After, joinPoint: execution(void io.github.dunwu.springboot.service.HelloWorldService.getException())");
		assertThat(output).contains(
			"call @AfterThrowing, joinPoint: execution(void io.github.dunwu.springboot.service.HelloWorldService.getException())");
		// end::config[]
		// @formatter:on

	}

}
