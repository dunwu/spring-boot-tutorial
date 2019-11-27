package io.github.dunwu.springboot.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * 用户实体，对应 user 表
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019-11-18
 */
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户基本信息")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(name = "ID", hidden = true, example = "0")
	private Long id;

	@NotNull
	@Column(unique = true)
	@Length(min = 4, max = 30)
	@ApiModelProperty(name = "用户名", example = "user")
	private String username;

	@NotNull
	@Length(min = 6, max = 60)
	@ApiModelProperty(name = "密码", example = "123456")
	private String password;

	@NotNull
	@Email
	@Column(unique = true)
	@ApiModelProperty(name = "用户名", example = "xxx@xxx.com")
	private String email;

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof User)) {
			return false;
		}

		User user = (User) o;

		if (id != null && id.equals(user.id)) {
			return true;
		}

		return username.equals(user.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username);
	}

}
