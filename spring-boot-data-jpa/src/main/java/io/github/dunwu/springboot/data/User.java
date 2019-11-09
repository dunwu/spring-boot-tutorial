package io.github.dunwu.springboot.data;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Integer age;

	private String address;

	private String email;

	public User() {}

	public User(String name, Integer age, String address, String email) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
	}

}
