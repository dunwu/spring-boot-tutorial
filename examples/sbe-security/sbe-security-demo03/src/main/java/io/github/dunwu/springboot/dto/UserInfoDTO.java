package io.github.dunwu.springboot.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019-06-13
 */
public class UserInfoDTO {

	private String name;

	private String avatar;

	private String introduction;

	private String token;

	private List<String> roles;

	public UserInfoDTO() {
		this.roles = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserInfoDTO{" + "name='" + name + '\'' + ", avatar='" + avatar + '\'' + ", introduction='"
			+ introduction + '\'' + ", token='" + token + '\'' + ", roles=" + roles + '}';
	}

}
