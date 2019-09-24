package io.github.dunwu.springboot;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DisabledTestsDemo {

	@Disabled
	@Test
	void testWillBeSkipped() {
	}

	@Test
	void testWillBeExecuted() {
	}

}
