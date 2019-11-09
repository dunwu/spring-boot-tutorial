package io.github.dunwu.springboot;

import io.github.dunwu.springboot.config.DunwuProperties;
import io.github.dunwu.springboot.config.GenderEnum;
import io.github.dunwu.springboot.config.ValidatedProperties;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootPropertyApplicationTests {

	@Rule
	public final OutputCapture output = new OutputCapture();

	private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

	@Autowired
	private DunwuProperties dunwuProperties;

	@Test
	public void bindDunwuProperties() {
		Map<String, String> infoMap = new HashMap<>();
		infoMap.put("education", "master's degree");
		infoMap.put("career", "programmer");

		Map<String, List<String>> skillMap = new HashMap<>();
		skillMap.put("JavaCore", Arrays.asList("JDK", "JVM"));
		skillMap.put("JavaWeb", Arrays.asList("Spring", "Spring Boot", "MyBatis"));

		assertThat(dunwuProperties.getId()).isEqualTo(1);
		assertThat(dunwuProperties.getAuthor()).isEqualTo("Zhang Peng");
		assertThat(dunwuProperties.getMail()).isEqualTo("forbreak@163.com");
		assertThat(dunwuProperties.getSex()).isEqualTo(GenderEnum.MALE);
		assertThat(dunwuProperties.getInterestList()).containsAll(Arrays.asList("Music", "Game", "Reading"));
		assertThat(dunwuProperties.getInfoMap()).containsAllEntriesOf(infoMap);
		assertThat(dunwuProperties.getSkillMap()).containsAllEntriesOf(skillMap);
	}

	@Test
	public void bindInvalidHost() {
		this.context.register(SpringBootPropertyApplication.class);
		TestPropertyValues.of("validator.host:xxxxxx", "validator.port:9090").applyTo(this.context);
		assertThatExceptionOfType(BeanCreationException.class).isThrownBy(this.context::refresh)
			.withMessageContaining("Failed to bind properties under 'validator'");
	}

	@Test
	public void bindNullHost() {
		this.context.register(SpringBootPropertyApplication.class);
		assertThatExceptionOfType(BeanCreationException.class).isThrownBy(this.context::refresh)
			.withMessageContaining("Failed to bind properties under 'validator'");
	}

	@Test
	public void bindValidProperties() {
		this.context.register(SpringBootPropertyApplication.class);
		TestPropertyValues.of("validator.host:127.0.0.1", "validator.port:9090").applyTo(this.context);
		this.context.refresh();
		ValidatedProperties properties = this.context.getBean(ValidatedProperties.class);
		assertThat(properties.getHost()).isEqualTo("127.0.0.1");
		assertThat(properties.getPort()).isEqualTo(Integer.valueOf(9090));
	}

	@After
	public void closeContext() {
		this.context.close();
	}

}
