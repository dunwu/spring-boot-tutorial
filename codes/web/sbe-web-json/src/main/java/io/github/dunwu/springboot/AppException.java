package io.github.dunwu.springboot;

/**
 * @author Zhang Peng
 * @date 2018-12-29
 */
public class AppException extends RuntimeException {

    public AppException() {
        super();
    }

    public AppException(String message) {
        super(message);
    }
}
