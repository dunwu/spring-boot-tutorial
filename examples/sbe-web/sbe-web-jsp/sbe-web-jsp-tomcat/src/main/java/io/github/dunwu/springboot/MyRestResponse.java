package io.github.dunwu.springboot;

public class MyRestResponse {

	private String message;

	public MyRestResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
