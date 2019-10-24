package io.github.dunwu.springboot;

/**
 * @author Zhang Peng
 * @since 2018-12-29
 */
public enum CodeEn {

	SUCCESS(0, "成功"), APP_ERROR(-1, "系统内部错误"), OTHER_ERROR(-2, "其他错误");

	private Integer code;

	private String message;

	CodeEn(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer code() {
		return code;
	}

	public String message() {
		return message;
	}
}
