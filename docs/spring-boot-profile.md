# SpringBoot 教程之 profile 的应用

> 一个应用为了在不同的环境下工作，常常会有不同的配置，代码逻辑处理。Spring Boot 对此提供了简便的支持。
>
> 关键词： `@Profile`、`spring.profiles.active`

<!-- TOC depthFrom:2 depthTo:3 -->

- [1. 区分环境的配置](#1-区分环境的配置)
  - [1.1. properties 配置](#11-properties-配置)
  - [1.2. yml 配置](#12-yml-配置)
- [2. 区分环境的代码](#2-区分环境的代码)
  - [2.1. 修饰类](#21-修饰类)
  - [2.2. 修饰注解](#22-修饰注解)
  - [2.3. 修饰方法](#23-修饰方法)
- [3. 激活 profile](#3-激活-profile)
  - [3.1. 插件激活 profile](#31-插件激活-profile)
  - [3.2. main 方法激活 profile](#32-main-方法激活-profile)
  - [3.3. jar 激活 profile](#33-jar-激活-profile)
  - [3.4. 在 Java 代码中激活 profile](#34-在-java-代码中激活-profile)
- [4. 示例源码](#4-示例源码)
- [5. 参考资料](#5-参考资料)

<!-- /TOC -->

## 1. 区分环境的配置

### 1.1. properties 配置

假设，一个应用的工作环境有：dev、test、prod

那么，我们可以添加 4 个配置文件：

- `applcation.properties` - 公共配置
- `application-dev.properties` - 开发环境配置
- `application-test.properties` - 测试环境配置
- `application-prod.properties` - 生产环境配置

在 `applcation.properties` 文件中可以通过以下配置来激活 profile：

```properties
spring.profiles.active = test
```

### 1.2. yml 配置

与 properties 文件类似，我们也可以添加 4 个配置文件：

- `applcation.yml` - 公共配置
- `application-dev.yml` - 开发环境配置
- `application-test.yml` - 测试环境配置
- `application-prod.yml` - 生产环境配置

在 `applcation.yml` 文件中可以通过以下配置来激活 profile：

```yml
spring:
  profiles:
    active: prod
```

此外，yml 文件也可以在一个文件中完成所有 profile 的配置：

```yml
# 激活 prod
spring:
  profiles:
    active: prod
# 也可以同时激活多个 profile
# spring.profiles.active: prod,proddb,prodlog
---
# dev 配置
spring:
  profiles: dev

# 略去配置

---
spring:
  profiles: test

# 略去配置

---
spring.profiles: prod
spring.profiles.include:
  - proddb
  - prodlog

---
spring:
  profiles: proddb

# 略去配置

---
spring:
  profiles: prodlog
# 略去配置
```

注意：不同 profile 之间通过 `---` 分割

## 2. 区分环境的代码

使用 `@Profile` 注解可以指定类或方法在特定的 Profile 环境生效。

### 2.1. 修饰类

```java
@Configuration
@Profile("production")
public class JndiDataConfig {

    @Bean(destroyMethod="")
    public DataSource dataSource() throws Exception {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
    }
}
```

### 2.2. 修饰注解

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Profile("production")
public @interface Production {
}
```

### 2.3. 修饰方法

```java
@Configuration
public class AppConfig {

    @Bean("dataSource")
    @Profile("development")
    public DataSource standaloneDataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("classpath:com/bank/config/sql/schema.sql")
            .addScript("classpath:com/bank/config/sql/test-data.sql")
            .build();
    }

    @Bean("dataSource")
    @Profile("production")
    public DataSource jndiDataSource() throws Exception {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
    }
}
```

## 3. 激活 profile

### 3.1. 插件激活 profile

```
spring-boot:run -Drun.profiles=prod
```

### 3.2. main 方法激活 profile

```
--spring.profiles.active=prod
```

### 3.3. jar 激活 profile

```
java -jar -Dspring.profiles.active=prod *.jar
```

### 3.4. 在 Java 代码中激活 profile

直接指定环境变量来激活 profile：

```java
System.setProperty("spring.profiles.active", "test");
```

在 Spring 容器中激活 profile：

```java
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
ctx.getEnvironment().setActiveProfiles("development");
ctx.register(SomeConfig.class, StandaloneDataConfig.class, JndiDataConfig.class);
ctx.refresh();
```

## 4. 示例源码

> 示例源码：[spring-boot-profile](https://github.com/dunwu/spring-boot-tutorial/tree/master/spring-boot-profile)

## 5. 参考资料

- [Spring 官方文档之 Bean Definition Profiles](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-definition-profiles)
- [Spring Boot 官方文档之 boot-features-profiles](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-profiles)
