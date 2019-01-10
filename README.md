# spring-boot-tutorial

> 这是一个 Spring Boot 实战教程，通过大量丰富的示例，展示 Spring Boot 在各个应用领域的应用。本项目旨在覆盖 Java 应用的各领域。
>
> 本项目的源码使用 maven 进行构建管理，任意 maven module 都可以独立运行。
>
> :construction: 正在不断完善、丰富示例中。。。

|         :gem:          |    :spider_web:     |       :package:        |       :phone:       |       :link:        |        :bento:        | :heavy_plus_sign: |
| :--------------------: | :-----------------: | :--------------------: | :-----------------: | :-----------------: | :-------------------: | ----------------- |
| [Core](#corecodescore) | [Web](#webcodesweb) | [Data](#datacodesdata) | [Message](#message) | [Lib](#libcodeslib) | [Template](#template) | [Others](#others) |

## [Core](codes/core)

| 示例项目                                          | 说明                                                         |
| ------------------------------------------------- | ------------------------------------------------------------ |
| [sbe-core-property](codes/core/sbe-core-property) | 展示 Spring Boot 中如何读写 Spring Boot 配置属性。           |
| [sbe-core-profile](codes/core/sbe-core-profile)   | 展示 Spring Boot 中如何配置 Profile 来使得应用能在不同运行环境使用各自的配置。 |
| [sbe-core-aop](codes/core/sbe-core-aop)           | 展示 Spring Boot 中如何使用 AOP 进行切面编程。               |
| [sbe-core-cache](codes/core/sbe-core-cache)       | 展示 Spring Boot 中如何使用简单的应用缓存。                  |
| [sbe-core-asyn](codes/core/sbe-core-asyn)         | 展示 Spring Boot 中如何支持异步方法。                        |
| [sbe-core-banner](codes/core/sbe-core-banner)     | 展示 Spring Boot 中如何定制 Banner。                         |

## [Web](codes/web)

> 本章节展示 Spring Boot 在 Java Web 开发的各个领域的应用。

| 示例项目                                           | 说明                                                                                                                                                                               |
| -------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [sbe-web-helloworld](codes/web/sbe-web-helloworld) | 展示 Spring Boot Web 应用的 Hello World 示例。                                                                                                                                     |
| [sbe-web-form](codes/web/sbe-web-form)             | 展示 Spring Boot Web 应用中表单如何提交、校验。                                                                                                                                    |
| [sbe-web-json](codes/web/sbe-web-json)             | 展示 Spring Boot Web 应用中如何使用 json 序列化、反序列化。                                                                                                                        |
| [sbe-web-jsp](codes/web/sbe-web-jsp)               | 展示 Spring Boot Web 应用中如何运行 JSP，提供 2 种服务器的整合示例：Tomcat、 Jetty。                                                                                               |
| [sbe-web-websocket](codes/web/sbe-web-websocket)   | 展示 Spring Boot Web 应用中如何运行 WebSocket，提供 3 种服务器的整合示例：Tomcat、Jetty、Undertow。                                                                                |
| [sbe-web-ui](codes/web/sbe-web-ui)                 | 展示 Spring Boot Web 应用中如何整合前端 UI。目前已完成的示例有：[整合 Bootstrap](codes/web/sbe-web-ui/sbe-web-ui-bootstrap)、[整合 EasyUI](codes/web/sbe-web-ui/sbe-web-ui-easyui) |

## [Data](codes/data)

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

## Message

- [sbe-msg-activemq](codes/message/sbe-msg-activemq) - Spring Boot 中使用 ActiveMQ 作为消息队列
- [sbe-msg-jms](codes/message/sbe-msg-jms) - Spring Boot 中使用 JMS
- [sbe-msg-kafka](codes/message/sbe-msg-kafka) - Spring Boot 中使用 Kafka 作为消息队列
- [sbe-msg-redis](codes/message/sbe-msg-redis) - Spring Boot 中使用 Redis 作为消息队列

## [Lib](codes/lib)

> 本章节展示 Spring Boot 如何整合各种主流 Java 库。

### Java Bean

| 示例项目                                              | 说明                                                                              |
| ----------------------------------------------------- | --------------------------------------------------------------------------------- |
| [sbe-lib-bean-dozer](codes/core/sbe-lib-bean-dozer)   | 展示 Spring Boot 中使用 Dozer， 来映射 JavaBean。                                 |
| [sbe-lib-bean-lombok](codes/core/sbe-lib-bean-lombok) | 展示 Spring Boot 中应用 Lombok，简化 JavaBean，避免写大量的 getter、setter 代码。 |

### 日志

| 示例项目                                             | 说明                                                               |
| ---------------------------------------------------- | ------------------------------------------------------------------ |
| [sbe-lib-log-simple](codes/log/sbe-lib-log-simple)   | 无需 xml 配置，展示使用 Spring Boot 中的日志相关属性定义日志配置。 |
| [sbe-lib-log-logback](codes/log/sbe-lib-log-logback) | 展示 Spring Boot 中使用 Logback 记录日志。                         |
| [sbe-lib-log-log4j2](codes/log/sbe-lib-log-log4j2)   | 展示 Spring Boot 中使用 Log4j2 记录日志。                          |
| [sbe-lib-log-log4j](codes/log/sbe-lib-log-log4j)     | 展示 Spring Boot 中使用 Log4j 记录日志。                           |

### 邮件

| 示例项目                               | 说明                              |
| -------------------------------------- | --------------------------------- |
| [sbe-lib-mail](codes/lib/sbe-lib-mail) | 展示 Spring Boot 中如何收发邮件。 |

### 测试

| 示例项目                                              | 说明                                          |
| ----------------------------------------------------- | --------------------------------------------- |
| [sbe-lib-test-junit5](codes/test/sbe-lib-test-junit5) | 展示 Spring Boot 中使用 JUnit5 进行单元测试。 |

## Template

> 本章节展示 Spring Boot 如何整合模板引擎。

| 示例项目                                            | 说明                                         |
| --------------------------------------------------- | -------------------------------------------- |
| [sbe-tmpl-freemark](codes/tmpl/sbe-tmpl-freemark)   | 展示 Spring Boot 中使用 Freemark 模板引擎。  |
| [sbe-tmpl-thymeleaf](codes/tmpl/sbe-tmpl-thymeleaf) | 展示 Spring Boot 中使用 Thymeleaf 模板引擎。 |

## Others

> 本章节的内容由于不好分类，所以并为一章节。

| 示例项目                                  | 说明                                        |
| ----------------------------------------- | ------------------------------------------- |
| [sbe-docker](codes/others/sbe-docker)     | 展示 Spring Boot 如何通过 Docker 部署应用。 |
| [sbe-schedule](codes/others/sbe-schedule) | 展示 Spring Boot 如何使用简单的调度器。     |
