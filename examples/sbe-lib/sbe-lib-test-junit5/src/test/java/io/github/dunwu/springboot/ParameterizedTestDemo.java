package io.github.dunwu.springboot;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Zhang Peng
 * @date 2018-12-22
 */
public class ParameterizedTestDemo {

	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromes(String candidate) {
		assertTrue(isMoreThan7(candidate));
	}

	private boolean isMoreThan7(String str) {
		if (str == null || str.length() <= 0) {
			return false;
		}

		if (str.length() > 7) {
			return true;
		}
		else {
			return false;
		}
	}

}
