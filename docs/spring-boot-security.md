# SpringBoot 集成 Spring Security 管理认证权限

## QuickStart

（1）添加依赖

```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
```

（2）添加配置

```properties
spring.security.user.name = root
spring.security.user.password = root
spring.security.user.roles = USER
```

（3）启动应用后，访问任意路径，都会出现以下页面，提示你先执行登录操作。输入配置的用户名、密码（root/root）即可访问应用页面。

![img](http://dunwu.test.upcdn.net/snap/image-20191118150326556.png)
