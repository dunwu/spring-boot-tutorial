package io.github.dunwu.springboot.service.impl;

import io.github.dunwu.springboot.service.MessageService;
import io.github.dunwu.springboot.service.Production;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Production
public class ProdProfileService implements MessageService {

	@Value("${dunwu.message:Production Begin!}")
	private String message;

	@Override
	public String getMessage() {
		return this.message;
	}

}
