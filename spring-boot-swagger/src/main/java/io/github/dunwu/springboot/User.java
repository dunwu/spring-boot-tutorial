package io.github.dunwu.springboot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户基本信息")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(name = "ID", readOnly = true, hidden = true, example = "0")
	private Long id;

	@Column(unique = true)
	@Size(max = 20)
	@ApiModelProperty(name = "姓名", example = "dunwu")
	private String name;

	@Max(150)
	@Min(1)
	@ApiModelProperty(name = "年龄", example = "18")
	private Integer age;

	@NotNull
	@ApiModelProperty(name = "地址", example = "南京市")
	private String address;

	@Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
	@ApiModelProperty(name = "邮件", example = "xxx@163.com")
	private String email;

}
