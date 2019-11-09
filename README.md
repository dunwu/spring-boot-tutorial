# Spring Boot Tutorial

> Spring Boot 教程
>
> 这是一个 Spring Boot 实战教程，通过大量丰富的示例，展示 Spring Boot 在各个应用领域的应用。本项目旨在覆盖 Java 应用的各领域。
>
> 本项目的源码使用 maven 进行构建管理，任意 maven module 都可以独立运行。
>
> - 🔁 项目同步维护：[Github](https://github.com/dunwu/spring-boot-tutorial/) | [Gitee](https://gitee.com/turnon/spring-boot-tutorial/)
> - 📖 电子书阅读：[Github Pages](https://dunwu.github.io/spring-boot-tutorial/) | [Gitee Pages](http://turnon.gitee.io/spring-boot-tutorial/)

|     :gem:     | :spider_web: |   :package:   |       :phone:       |   :link:    |        :bento:        | :heavy_plus_sign: |
| :-----------: | :----------: | :-----------: | :-----------------: | :---------: | :-------------------: | ----------------- |
| [Core](#core) | [Web](#web)  | [Data](#data) | [Message](#message) | [Lib](#lib) | [Template](#template) | [Others](#others) |

## Core

> [Core](examples/sbe-core) 章节展示 Spring Boot 核心应用。

| 示例项目                                                        | 说明                                                                           |
| --------------------------------------------------------------- | ------------------------------------------------------------------------------ |
| [SpringBoot 教程之属性加载详解](spring-boot-property) | 展示 Spring Boot 中如何读写 Spring Boot 配置属性。                             |
| [SpringBoot 教程之 profile](spring-boot-profile)      | 展示 Spring Boot 中如何配置 Profile 来使得应用能在不同运行环境使用各自的配置。 |
| [spring-boot-aop](spring-boot-aop)                  | 展示 Spring Boot 中如何使用 AOP 进行切面编程。                                 |
| [SpringBoot 教程之处理异步请求](spring-boot-async)     | 展示 Spring Boot 中如何支持异步方法。                                          |
| [SpringBoot 教程之 banner 定制](spring-boot-banner)   | 展示 Spring Boot 中如何定制 Banner。                                           |

## Web

> [Web](examples/sbe-web) 章节展示 Spring Boot 在 Java Web 开发的各个领域的应用。

| 示例项目                                                  | 说明                                                                                                                                                                                             |
| --------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| [spring-boot-web-helloworld](spring-boot-helloworld) | 展示 Spring Boot Web 应用的 Hello World 示例。                                                                                                                                                   |
| [spring-boot-web-form](spring-boot-web-form)             | 展示 Spring Boot Web 应用中表单如何提交、校验。                                                                                                                                                  |
| [spring-boot-web-json](spring-boot-web-fastjson)             | 展示 Spring Boot Web 应用中如何使用 json 序列化、反序列化。                                                                                                                                      |
| [spring-boot-web-jsp](spring-boot-web-jsp)               | 展示 Spring Boot Web 应用中如何运行 JSP，提供 2 种服务器的整合示例：Tomcat、 Jetty。                                                                                                             |
| [spring-boot-web-websocket](spring-boot-web-websocket)   | 展示 Spring Boot Web 应用中如何运行 WebSocket，提供 3 种服务器的整合示例：Tomcat、Jetty、Undertow。                                                                                              |
| [spring-boot-web-ui](spring-boot-web-ui)                 | 展示 Spring Boot Web 应用中如何整合前端 UI。目前已完成的示例有：[整合 Bootstrap](spring-boot-web-ui/spring-boot-web-ui-bootstrap)、[整合 EasyUI](spring-boot-web-ui/spring-boot-web-ui-easyui) |

## Data

> [Data](examples/sbe-data) 章节展示 Spring Boot 在数据层面应用。

### Sql

> 展示 Spring Boot 中访问关系型数据库的方式。注意：如果没有特殊说明，数据篇关系型数据库的配置为：普通 profile 使用 Mysql；单元测试中 profile 为 test， 使用 H2 数据库

| 示例项目                                                                              | 说明                                                                             |
| ------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| [spring-boot-data-jdbc](spring-boot-data-jdbc)                                      | 展示在 Spring Boot 中，如何使用 JDBC 访问数据。                                  |
| [spring-boot-data-jdbc-multi-datasource](spring-boot-data-jdbc-multi-datasource)    | 展示在 Spring Boot 中，如何使用 JDBC 访问多数据源。                              |
| [spring-boot-data-jpa](spring-boot-data-jpa)                                        | Spring Boot 中使用 JPA 访问数据。                                                |
| [spring-boot-data-mybatis](spring-boot-data-mybatis)                                | Spring Boot + Mybatis Plus 访问数据。                                            |
| [spring-boot-data-mybatis-multi-datasource](spring-boot-data-jdbc-multi-datasource) | Spring Boot + Mybatis Plus 访问多数据源。                                        |
| [spring-boot-data-mybatis-sharding](spring-boot-data-mybatis-sharding)              | Spring Boot + Mybatis Plus + ShardingSphere (sharding-jdbc) 访问分库分表的数据。 |
| [spring-boot-data-flyway](spring-boot-data-mybatis)                                 | Spring Boot 中通过 flyway 控制 sql 版本。                                        |

### NoSql

| 示例项目                                                           | 说明                                    |
| ------------------------------------------------------------------ | --------------------------------------- |
| [spring-boot-data-redis](spring-boot-data-redis)                 | Spring Boot 中访问 redis。              |
| [spring-boot-data-redis-cluster](spring-boot-data-redis-cluster) | Spring Boot 中访问 redis 集群。         |
| [spring-boot-data-mongodb](spring-boot-data-mongodb)             | Spring Boot 中访问 mongodb 数据。       |
| [spring-boot-data-elasticsearch](spring-boot-data-elasticsearch) | Spring Boot 中访问 elasticsearch 数据。 |

### 缓存

| 示例项目                                                             | 说明                                             |
| -------------------------------------------------------------------- | ------------------------------------------------ |
| [spring-boot-cache](spring-boot-data-cache)                   | 展示 Spring Boot 中如何使用简单的应用缓存。      |
| [spring-boot-data-cache-j2cache](spring-boot-data-cache-j2cache)   | 展示 Spring Boot + J2Cache 实现分布式二级缓存。  |
| [spring-boot-data-cache-jetcache](spring-boot-data-cache-jetcache) | 展示 Spring Boot + Jetcache 实现分布式二级缓存。 |

## Message

| 示例项目                                              | 说明                                       |
| ----------------------------------------------------- | ------------------------------------------ |
| [spring-boot-msg-activemq](examples/spring-boot-msg/spring-boot-msg-activemq) | Spring Boot 中使用 ActiveMQ 作为消息队列。 |
| [spring-boot-msg-kafka](examples/spring-boot-msg/spring-boot-msg-kafka)       | Spring Boot 中使用 Kafka 作为消息队列。    |
| [spring-boot-msg-redis](examples/spring-boot-msg/spring-boot-msg-redis)       | Spring Boot 中使用 Redis 作为消息队列。    |

## Lib

> [Lib](examples/sbe-lib) 章节展示 Spring Boot 如何整合各种主流 Java 库。

### Java Bean

| 示例项目                                                    | 说明                                                                              |
| ----------------------------------------------------------- | --------------------------------------------------------------------------------- |
| [sbe-lib-bean-dozer](examples/sbe-lib/sbe-lib-bean-dozer)   | 展示 Spring Boot 中使用 Dozer， 来映射 JavaBean。                                 |
| [sbe-lib-bean-lombok](examples/sbe-lib/sbe-lib-bean-lombok) | 展示 Spring Boot 中应用 Lombok，简化 JavaBean，避免写大量的 getter、setter 代码。 |

### 日志

| 示例项目                                                    | 说明                                                               |
| ----------------------------------------------------------- | ------------------------------------------------------------------ |
| [spring-boot-logging-simple](examples/sbe-lib/spring-boot-logging-simple)   | 无需 xml 配置，展示使用 Spring Boot 中的日志相关属性定义日志配置。 |
| [spring-boot-logging-logback](examples/sbe-lib/spring-boot-logging-logback) | 展示 Spring Boot 中使用 Logback 记录日志。                         |
| [spring-boot-logging-log4j2](examples/sbe-lib/spring-boot-logging-log4j2)   | 展示 Spring Boot 中使用 Log4j2 记录日志。                          |
| [spring-boot-logging-log4j](examples/sbe-lib/spring-boot-logging-log4j)     | 展示 Spring Boot 中使用 Log4j 记录日志。                           |

### 邮件

| 示例项目                                      | 说明                              |
| --------------------------------------------- | --------------------------------- |
| [sbe-lib-mail](examples/sbe-lib/sbe-lib-mail) | 展示 Spring Boot 中如何收发邮件。 |

### 测试

| 示例项目                                                    | 说明                                          |
| ----------------------------------------------------------- | --------------------------------------------- |
| [sbe-lib-test-junit5](examples/sbe-lib/sbe-lib-test-junit5) | 展示 Spring Boot 中使用 JUnit5 进行单元测试。 |

## Template

> 本章节展示 Spring Boot 如何整合模板引擎。

| 示例项目                                                   | 说明                                         |
| ---------------------------------------------------------- | -------------------------------------------- |
| [spring-boot-tmpl-freemark](examples/spring-boot-tmpl/spring-boot-tmpl-freemark)   | 展示 Spring Boot 中使用 Freemark 模板引擎。  |
| [spring-boot-tmpl-thymeleaf](examples/spring-boot-tmpl/spring-boot-tmpl-thymeleaf) | 展示 Spring Boot 中使用 Thymeleaf 模板引擎。 |

## Others

> 本章节的内容由于不好分类，所以并为一章节。

| 示例项目                                                       | 说明                                           |
| -------------------------------------------------------------- | ---------------------------------------------- |
| [sbe-docker](examples/sbe-others/sbe-docker)                   | 展示 Spring Boot 如何通过 Docker 部署应用。    |
| [sbe-schedule](examples/sbe-others/sbe-schedule)               | 展示 Spring Boot 如何使用简单的调度器。        |
| [spring-boot-scheduler-quartz](examples/sbe-others/spring-boot-scheduler-quartz) | 展示 Spring Boot + Quartz 管理、使用调度任务。 |
| [sbe-statemachine](examples/sbe-others/sbe-statemachine)       | 展示 Spring Boot 如何使用状态机控制工作流。    |
