---
home: true
heroImage: img/bg.gif
heroText: Spring Boot Tutorial
tagline: ☕ `spring-boot-tutorial` 是一个 Spring Boot 实战教程，通过大量丰富的示例，展示 Spring Boot 在各个应用领域的应用。本项目旨在覆盖 Java 应用的各领域。
bannerBg: none
postList: none
footer: CC-BY-SA-4.0 Licensed | Copyright © 2018-Now Dunwu
---

<p align="center">

  <a href="https://github.com/dunwu/spring-boot-tutorial">
      <img alt="star" class="no-zoom" src="https://img.shields.io/github/stars/dunwu/spring-boot-tutorial?style=for-the-badge">
  </a>

  <a href="https://github.com/dunwu/spring-boot-tutorial">
      <img alt="fork" class="no-zoom" src="https://img.shields.io/github/forks/dunwu/spring-boot-tutorial?style=for-the-badge">
  </a>

  <a href="https://github.com/dunwu/spring-boot-tutorial/commits/master">
      <img alt="commit" class="no-zoom" src="https://img.shields.io/github/workflow/status/dunwu/spring-boot-tutorial/CI?style=for-the-badge">
  </a>

  <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.zh">
      <img alt="code style" class="no-zoom" src="https://img.shields.io/github/license/dunwu/spring-boot-tutorial?style=for-the-badge">
  </a>

</p>

> `spring-boot-tutorial` 是一个 Spring Boot 实战教程，通过大量丰富的示例，展示 Spring Boot 在各个应用领域的应用。本项目旨在覆盖 Java 应用的各领域。
>
> 本项目的源码使用 maven 进行构建管理，任意 maven module 都可以独立编译运行。
>
> - 🔁 项目同步维护：[Github](https://github.com/dunwu/spring-boot-tutorial/) | [Gitee](https://gitee.com/turnon/spring-boot-tutorial/)
> - 📖 电子书阅读：[Github Pages](https://dunwu.github.io/spring-boot-tutorial/) | [Gitee Pages](http://turnon.gitee.io/spring-boot-tutorial/)

## 🔰 准备

- [java-tutorial](https://dunwu.github.io/java-tutorial/) - java-tutorial 是一个全面的 Java 教程。如果你还不熟悉 Java 编程，学习 Spring Boot 之前，不妨先学习一下。
- [spring-tutorial](https://dunwu.github.io/spring-tutorial/) - spring-tutorial 是一个 Spring 实战教程。Spring 是 Spring Boot 的基石，如果想更深入了解 SpringBoot，还是很有必要了解一下 Spring 框架机制。

## 🎯 示例

### Spring Boot 基础

- [spring-boot-actuator](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/core/spring-boot-actuator) - 展示 Spring Boot 应用监控。
- [spring-boot-aop](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/core/spring-boot-aop) - 展示 Spring Boot 中应用 AOP 编程。
- [spring-boot-async](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/core/spring-boot-async) - 展示在 Spring Boot 中使用异步接口。
- [spring-boot-banner](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/core/spring-boot-banner) - 展示在 Spring Boot 中定制启动时的输出 Logo。
- [spring-boot-bean](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/core/spring-boot-bean) - 展示 Spring Boot 中应用 Lombok，简化大量的 getter、setter 、toString 等模板化代码；以及应用 Dozer 来简化大量的 JavaBean 互相转换代码。
- [spring-boot-profile](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/core/spring-boot-profile) - 展示 Spring Boot 中根据 profile 使程序在不同的环境下执行不同的行为。
- [spring-boot-property](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/core/spring-boot-property) - 全方位的演示 Spring Boot 加载属性的方式：记载 `properties` 和 `yaml` 两种文件；通过 `@Value`、`@ConfigurationProperties`、`Environment` 读取属性。

### Spring Boot 访问存储

#### 关系型数据库

- [spring-boot-data-jdbc](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-jdbc) - 演示 Spring Boot + JDBC 访问关系型数据库，执行基本的 CRUD 操作。
- [spring-boot-data-jdbc-multi-datasource](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-jdbc-multi-datasource) - 演示 Spring Boot + JDBC 访问多数据源（可以是多个数据库服务器，也可以是多个截然不同的数据库）。
- [spring-boot-data-jpa](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-jpa) - 演示 Spring Boot + JPA 访问关系型数据库，支持基本的 CRUD 操作以及直接支持 REST 接口方式访问数据。
- [spring-boot-data-mybatis-multi-datasource](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-mybatis-multi-datasource) - Spring Boot + Mybatis Plus 访问多数据源。
- [spring-boot-data-mybatis-plus](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-mybatis-plus) - Spring Boot + Mybatis Plus 访问数据。
- [spring-boot-data-flyway](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-flyway) - Spring Boot 中通过 flyway 控制 sql 版本。
- [spring-boot-data-mybatis-sharding](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-mybatis-sharding) - Spring Boot + Mybatis Plus + ShardingSphere (sharding-jdbc) 访问分库分表数据。

#### Nosql 数据库

- [spring-boot-data-redis](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-redis) - 展示 Spring Boot 中访问 Redis。
- [spring-boot-data-redis-cluster](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-redis-cluster) - 展示 Spring Boot 中访问 Redis 集群。
- [spring-boot-data-mongodb](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-mongodb) - 展示 Spring Boot 中访问 MongoDB。
- [spring-boot-data-elasticsearch](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-elasticsearch) - 展示 Spring Boot 中访问 elasticsearch 数据（TCP 方式访问 9300 服务端口）。
- [spring-boot-data-elasticsearch-jest](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-elasticsearch-jest) - 展示 Spring Boot 中访问 elasticsearch 数据（HTTP 方式访问 9200 服务端口）。

#### 缓存

- [spring-boot-data-cache](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-cache) - 展示 Spring Boot 中如何使用简单的应用缓存。
- [spring-boot-data-cache-j2cache](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-cache-j2cache) - 展示 Spring Boot + Jetcache 实现分布式二级缓存。
- [spring-boot-data-cache-jetcache](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/data/spring-boot-data-cache-jetcache) - 展示 Spring Boot + J2Cache 实现分布式二级缓存。

### Spring Boot 访问消息队列

- [spring-boot-mq-activemq](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/mq/spring-boot-mq-activemq) - 展示 Spring Boot 中使用 ActiveMQ 作为消息队列。
- [spring-boot-mq-kafka](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/mq/spring-boot-mq-kafka) - 展示 Spring Boot 中使用 Kafka 作为消息队列。
- [spring-boot-mq-redis](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/mq/spring-boot-mq-redis) - 展示 Spring Boot 中使用 Redis 作为消息队列。

### Spring Boot 集成安全框架

- [spring-boot-security-authentication](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/security/spring-boot-security-authentication)
- [spring-boot-security-checkcode](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/security/spring-boot-security-checkcode)
- [spring-boot-security-session](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/security/spring-boot-security-session)

### Spring Boot + Web

- [spring-boot-web-fastjson](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/web/spring-boot-web-fastjson) - 展示 Spring Boot Web 应用中如何集成 Fastjson （默认的 JSON 库为 ）并定制序列化、反序列化方式。
- [spring-boot-web-form](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/web/spring-boot-web-form) - 展示 Spring Boot Web 应用中表单如何提交、校验。
- [spring-boot-web-helloworld](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/web/spring-boot-web-helloworld) - 展示 Spring Boot Web 应用的 Hello World 示例。
- [spring-boot-web-helloworld](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/web/spring-boot-web-https) - 展示 Spring Boot 如何开发一个 HTTPS 应用。
- [spring-boot-web-multi-connectors](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/web/spring-boot-web-multi-connectors) - 展示 Spring Boot Web 应用如何同时支持 HTTP 协议和 HTTPS 协议访问。
- [spring-boot-web-ui](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/web/spring-boot-web-ui) - 展示 Spring Boot 和多种不同前端技术的交互。
- [spring-boot-web-uploading](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/web/spring-boot-web-uploading) - 展示 Spring Boot Web 应用中如何支持文件上传下载服务。
- [spring-boot-web-websocket](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/web/spring-boot-web-websocket) - 展示 Spring Boot Web 应用中如何运行 WebSocket，提供 3 种服务器的整合示例：Tomcat、Jetty、Undertow。

### Spring Boot 使用模板引擎

- [spring-boot-templ-jsp](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/template/spring-boot-templ-jsp) - 展示 Spring Boot Web 应用中如何运行 JSP，提供 2 种服务器的整合示例：Tomcat、 Jetty。
- [spring-boot-tmpl-freemark](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/template/spring-boot-tmpl-freemark) - 展示 Spring Boot 中使用 Freemark 模板引擎。
- [spring-boot-tmpl-thymeleaf](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/template/spring-boot-tmpl-thymeleaf) - 展示 Spring Boot 中使用 Thymeleaf 模板引擎。
- [spring-boot-tmpl-velocity](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/template/spring-boot-tmpl-velocity) - 展示 Spring Boot 中使用 Velocity 模板引擎。

### Spring Boot 集成各种框架

- [spring-boot-docker](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/integration/spring-boot-docker) - 展示 Spring Boot 如何通过 Docker 部署应用。
- [spring-boot-logging](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/integration/spring-boot-logging) - 展示 Spring Boot 集成日志组件。示例可以通过切换 profile 分别集成 logback、log4j2、log4j 三种日志库。
- [spring-boot-mail](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/integration/spring-boot-mail) - 展示 Spring Boot 中如何收发邮件。
- [spring-boot-scheduler](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/integration/spring-boot-scheduler) - 展示 Spring Boot 如何使用自带的调度器来执行简单的调度任务场景。
- [spring-boot-scheduler-quartz](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/integration/spring-boot-scheduler-quartz) - 展示 Spring Boot 集成 Quartz 来管理、调度较为复杂的调度任务场景。
- [spring-boot-statemachine](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/integration/spring-boot-statemachine) - 展示 Spring Boot 如何使用状态机控制工作流。
- [spring-boot-swagger](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/integration/spring-boot-swagger) - 展示 Spring Boot 集成 Swagger 来自动生成漂亮的 REST 接口在线文档。
- [spring-boot-test-junit5](https://github.com/dunwu/spring-boot-tutorial/tree/master/codes/integration/spring-boot-test-junit5) - 展示 Spring Boot 中使用 JUnit5 进行单元测试。

## 📖 文档

### Spring Boot 基础篇

- [SpringBoot 知识图谱](10.Java/13.框架/02.SpringBoot/00.SpringBoot综合/01.SpringBoot知识图谱.md)
- [SpringBoot 基本原理](10.Java/13.框架/02.SpringBoot/00.SpringBoot综合/02.SpringBoot基本原理.md)

### Spring Boot 基础篇

- [SpringBoot 教程之快速入门](10.Java/13.框架/02.SpringBoot/01.SpringBoot基础/01.SpringBoot之快速入门.md)
- [SpringBoot 之属性加载](10.Java/13.框架/02.SpringBoot/01.SpringBoot基础/02.SpringBoot之属性加载.md)
- [SpringBoot 之 Profile](10.Java/13.框架/02.SpringBoot/01.SpringBoot基础/03.SpringBoot之Profile.md)

### Spring Boot 数据篇

- [SpringBoot 之 JDBC](10.Java/13.框架/02.SpringBoot/03.SpringBoot数据/01.SpringBoot之JDBC.md)
- [SpringBoot 之 Mybatis](10.Java/13.框架/02.SpringBoot/03.SpringBoot数据/11.SpringBoot之Mybatis.md)
- [SpringBoot 之 Elasticsearch](10.Java/13.框架/02.SpringBoot/03.SpringBoot数据/22.SpringBoot之Elasticsearch.md)
- [SpringBoot 之 MongoDB](10.Java/13.框架/02.SpringBoot/03.SpringBoot数据/23.SpringBoot之MongoDB.md)

### Spring Boot IO 篇

- [SpringBoot 之异步请求](10.Java/13.框架/02.SpringBoot/04.SpringBootIO/01.SpringBoot之异步请求.md)
- [SpringBoot 之 Json](10.Java/13.框架/02.SpringBoot/04.SpringBootIO/02.SpringBoot之Json.md)
- [SpringBoot 之邮件](10.Java/13.框架/02.SpringBoot/04.SpringBootIO/03.SpringBoot之邮件.md)

## License

本博客所有文章除特别声明外，均采用 [![License: CC BY-NC-SA 4.0](https://licensebuttons.net/l/by-nc-sa/4.0/80x15.png)](https://creativecommons.org/licenses/by-nc-sa/4.0/) 许可协议。
