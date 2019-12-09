package io.github.dunwu.springboot.data;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@ToString
@Document(indexName = "user", type = "user", shards = 1, replicas = 0, refreshInterval = "-1")
public class User {

	@Id
	private String id;

	private String username;

	private String password;

	private String email;

	public User() {}

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

}
