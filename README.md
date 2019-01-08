# spring-boot-tutorial

> 这是一个 Spring Boot 实战教程，通过大量丰富的示例，展示 Spring Boot 在各个应用领域的应用。本项目旨在覆盖 Java 应用的各领域。
>
> 正在不断完善、丰富示例中。

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

> 本章节展示 Spring Boot 如何整合模板引擎。

| 示例项目                                            | 说明                                    |
| --------------------------------------------------- | --------------------------------------- |
| [sbe-tmpl-freemark](codes/tmpl/sbe-tmpl-freemark)   | Spring Boot 中使用 Freemark 模板引擎。  |
| [sbe-tmpl-thymeleaf](codes/tmpl/sbe-tmpl-thymeleaf) | Spring Boot 中使用 Thymeleaf 模板引擎。 |

## Test

- [sbe-test-junit5](codes/test/sbe-test-junit5) - Spring Boot 中使用 JUnit5 进行单元测试

## [Web](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/web)

> 本章节展示 Spring Boot 在 Java Web 开发的各个领域的应用。

| 示例项目                                           | 说明                                                         |
| -------------------------------------------------- | ------------------------------------------------------------ |
| [sbe-web-helloworld](codes/web/sbe-web-helloworld) | Spring Boot Web 应用的 Hello World 示例。                    |
| [sbe-web-form](codes/web/sbe-web-form)             | 展示 Spring Boot Web 应用中表单如何提交、校验。              |
| [sbe-web-json](codes/web/sbe-web-json)             | 展示 Spring Boot Web 应用中如何使用 json 序列化、反序列化。  |
| [sbe-web-jsp](codes/web/sbe-web-jsp)               | 展示 Spring Boot Web 应用中如何运行 JSP，提供 2 种服务器的整合示例：Tomcat、 Jetty。 |
| [sbe-web-websocket](codes/web/sbe-web-websocket)   | 展示 Spring Boot Web 应用中如何运行 WebSocket，提供 3 种服务器的整合示例：Tomcat、Jetty、Undertow。 |
| [sbe-web-ui](codes/web/sbe-web-ui)                 | 展示 Spring Boot Web 应用中如何整合前端 UI。目前已完成的示例有：[整合 Bootstrap](codes/web/sbe-web-ui/sbe-web-ui-bootstrap)、[整合 Eazyui](codes/web/sbe-web-ui/sbe-web-ui-eazyui) |