package io.github.dunwu.springboot.security.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = 3497935890426858541L;

	private String userName;

	private String password;

	private boolean accountNonExpired = true;

	private boolean accountNonLocked = true;

	private boolean credentialsNonExpired = true;

	private boolean enabled = true;

}
