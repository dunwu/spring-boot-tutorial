package io.github.dunwu.springboot;

import org.elasticsearch.client.transport.NoNodeAvailableException;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.rule.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

public class DataElasticsearchApplicationTests {

	@Rule
	public final OutputCapture output = new OutputCapture();

	@Test
	public void testDefaultSettings() {
		try {
			new SpringApplicationBuilder(DataElasticsearchApplication.class).run();
		} catch (Exception ex) {
			if (!elasticsearchRunning(ex)) {
				return;
			}
			throw ex;
		}
		assertThat(this.output.toString()).contains("firstName='Alice', lastName='Smith'");
	}

	private boolean elasticsearchRunning(Exception ex) {
		Throwable candidate = ex;
		while (candidate != null) {
			if (candidate instanceof NoNodeAvailableException) {
				return false;
			}
			candidate = candidate.getCause();
		}
		return true;
	}

}
