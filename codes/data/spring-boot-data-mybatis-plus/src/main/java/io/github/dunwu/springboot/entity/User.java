package io.github.dunwu.springboot.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String address;

    private String email;

    private String desc;

    public User() {
    }

    public User(String name, Integer age, String address, String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
    }

}
