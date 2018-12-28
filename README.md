# spring-boot-tutorial

## Core

- [sbe-bean-dozer](codes/core/sbe-bean-dozer) - Spring Boot 中应用 Dozer， 映射 JavaBean
- [sbe-bean-lombok](codes/core/sbe-bean-lombok) - Spring Boot 中应用 Lombok，简化 JavaBean
- [sbe-core-aop](codes/core/sbe-core-aop) - Spring Boot 中应用 AOP
- [sbe-core-banner](codes/core/sbe-core-banner) - Spring Boot 中定制 Banner
- [sbe-core-cache](codes/core/sbe-core-cache) - Spring Boot 中应用缓存
- [sbe-core-profile](codes/core/sbe-core-profile) - Spring Boot 中配置 Profile
- [sbe-core-property](codes/core/sbe-core-property) - Spring Boot 中读写属性

## Data

- **Sql**
  - [sbe-data-mysql](codes/data/sbe-data-mysql) - Spring Boot 中访问 mysql 数据
- **NoSql**
  - [sbe-data-elasticsearch](codes/data/sbe-data-elasticsearch) - Spring Boot 中访问 elasticsearch 数据
  - [sbe-data-mongodb](codes/data/sbe-data-mongodb) - Spring Boot 中访问 mongodb 数据
  - [sbe-data-redis](codes/data/sbe-data-redis) - Spring Boot 中访问 redis 数据
- **其他**
  - [sbe-data-flyway](codes/data/sbe-data-flyway) - Spring Boot 中通过 flyway 控制 sql 版本
  - [sbe-data-jdbc](codes/data/sbe-data-jdbc) - Spring Boot 中使用 JDBC
  - [sbe-data-jdbc-multi-connectors](codes/data/sbe-data-jdbc-multi-connectors) - Spring Boot 中使用 JDBC 多连接
  - [sbe-data-jpa](codes/data/sbe-data-jpa) - Spring Boot 中使用 JPA
  - [sbe-data-jpa-rest](codes/data/sbe-data-jpa-rest) - Spring Boot 中使用 JPA REST
  - [sbe-data-orm-mybatis](codes/data/sbe-data-orm-mybatis) - Spring Boot 中使用 Mybatis

## Deploy

- [sbe-docker](codes/deploy/sbe-docker) - Spring Boot 通过 Docker 部署

## IO

- [sbe-io-schedule](codes/io/sbe-io-schedule) - Spring Boot 中使用 Spring 内置调度器

## [Log](codes/log)

Spring Boot 默认使用 Logback 记录日志。建议使用 Slf4j + Loback 作为日志记录方案。

| 示例项目                                     | 说明                                                           |
| -------------------------------------------- | -------------------------------------------------------------- |
| [sbe-log-simple](codes/log/sbe-log-simple)   | 无需 xml 配置，使用 Spring Boot 中的日志相关属性定义日志配置。 |
| [sbe-log-logback](codes/log/sbe-log-logback) | Spring Boot 中使用 Logback 记录日志。                          |
| [sbe-log-log4j2](codes/log/sbe-log-log4j2)   | Spring Boot 中使用 Log4j2 记录日志。                           |
| [sbe-log-log4j](codes/log/sbe-log-log4j)     | Spring Boot 中使用 Log4j 记录日志。                            |

## Message

- [sbe-msg-activemq](codes/message/sbe-msg-activemq) - Spring Boot 中使用 ActiveMQ 作为消息队列
- [sbe-msg-jms](codes/message/sbe-msg-jms) - Spring Boot 中使用 JMS
- [sbe-msg-kafka](codes/message/sbe-msg-kafka) - Spring Boot 中使用 Kafka 作为消息队列
- [sbe-msg-redis](codes/message/sbe-msg-redis) - Spring Boot 中使用 Redis 作为消息队列

## Template

- [sbe-tmpl-freemark](codes/tmpl/sbe-tmpl-freemark) - Spring Boot 中使用 freemark 模板引擎
- [sbe-tmpl-thymeleaf](codes/tmpl/sbe-tmpl-thymeleaf) - Spring Boot 中使用 Thymeleaf 模板引擎

## Test

- [sbe-test-junit5](codes/test/sbe-test-junit5) - Spring Boot 中使用 JUnit5 进行单元测试

## Web

- [sbe-web-consuming-rest](codes/web/sbe-web-consuming-rest) - Spring Boot 中访问 rest 接口
- [sbe-web-form-submission](codes/web/sbe-web-form-submission) - Spring Boot 表单提交
- [sbe-web-form-validating](codes/web/sbe-web-form-validating) - Spring Boot 表单校验
- [sbe-web-helloworld](codes/web/sbe-web-helloworld) - Spring Boot 的 web 应用 Hello World 示例
- [sbe-web-jsp-jetty](codes/web/sbe-web-jsp-jetty) - Spring Boot 中使用 JSP，运行在 Jetty 服务器上
- [sbe-web-jsp-tomcat](codes/web/sbe-web-jsp-tomcat) - Spring Boot 中使用 JSP，运行在 Tomcat 服务器上
- [sbe-web-session](codes/web/sbe-web-session) - Spring Boot 中通过 redis 缓存管理 session
- [sbe-web-uploading](codes/web/sbe-web-uploading) - Spring Boot 中上传文件
- [sbe-web-websocket-jetty](codes/web/sbe-web-websocket-jetty) - Spring Boot 中使用 WebSocket，运行在 Jetty 服务器上
- [sbe-web-websocket-tomcat](codes/web/sbe-web-websocket-tomcat) - Spring Boot 中使用 WebSocket，运行在 Tomcat 服务器上
- [sbe-web-websocket-undertow](codes/web/sbe-web-websocket-undertow) - Spring Boot 中使用 WebSocket，运行在 Undertow 服务器上
