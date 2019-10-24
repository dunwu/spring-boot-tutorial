# spring-boot-tutorial

> 这是一个 Spring Boot 实战教程，通过大量丰富的示例，展示 Spring Boot 在各个应用领域的应用。本项目旨在覆盖 Java 应用的各领域。
>
> 本项目的源码使用 maven 进行构建管理，任意 maven module 都可以独立运行。
>
> 🚧 正在不断完善、丰富示例中。。。

## 核心篇

> [核心篇](core)

| 章节                                                       | 说明                                                                           |
| ---------------------------------------------------------- | ------------------------------------------------------------------------------ |
| [SpringBoot 教程之属性加载详解](core/sbe-core-property.md) | 展示 Spring Boot 中如何读写 Spring Boot 配置属性。                             |
| [SpringBoot 教程之 profile](core/sbe-core-profile.md)      | 展示 Spring Boot 中如何配置 Profile 来使得应用能在不同运行环境使用各自的配置。 |
| [SpringBoot 教程之处理异步请求](core/sbe-core-asyn.md)     | 展示 Spring Boot 中如何支持异步方法。                                          |
| [SpringBoot 教程之 banner 定制](core/sbe-core-banner.md)   | 展示 Spring Boot 中如何定制 Banner。                                           |

## Web 篇

> [Web 篇](web)

| 章节                                                  | 说明                                                                                                                                                                                     |
| ----------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [sbe-web-helloworld](../codes/web/sbe-web-helloworld) | 展示 Spring Boot Web 应用的 Hello World 示例。                                                                                                                                           |
| [sbe-web-form](../codes/web/sbe-web-form)             | 展示 Spring Boot Web 应用中表单如何提交、校验。                                                                                                                                          |
| [sbe-web-json](../codes/web/sbe-web-json)             | 展示 Spring Boot Web 应用中如何使用 json 序列化、反序列化。                                                                                                                              |
| [sbe-web-jsp](../codes/web/sbe-web-jsp)               | 展示 Spring Boot Web 应用中如何运行 JSP，提供 2 种服务器的整合示例：Tomcat、 Jetty。                                                                                                     |
| [sbe-web-websocket](../codes/web/sbe-web-websocket)   | 展示 Spring Boot Web 应用中如何运行 WebSocket，提供 3 种服务器的整合示例：Tomcat、Jetty、Undertow。                                                                                      |
| [sbe-web-ui](../codes/web/sbe-web-ui)                 | 展示 Spring Boot Web 应用中如何整合前端 UI。目前已完成的示例有：[整合 Bootstrap](../codes/web/sbe-web-ui/sbe-web-ui-bootstrap)、[整合 EasyUI](../codes/web/sbe-web-ui/sbe-web-ui-easyui) |

## 数据篇

> [数据篇](data)

| 章节                                                                                            | 说明                                                                |
| ----------------------------------------------------------------------------------------------- | ------------------------------------------------------------------- |
| [SpringBoot 教程之通过 JDBC 访问数据](data/sbe-data-jdbc.md)                                    | 展示在 Spring Boot 中，如何使用 `JdbcTemplate` 访问数据。           |
| [SpringBoot 教程之通过 JPA 访问数据](data/sbe-data-jpa.md)                                      | 展示 Spring Boot 中使用 JPA 访问数据。                              |
| [SpringBoot 教程之集成 MyBatis, 分页插件 PageHelper, 通用 Mapper](data/sbe-data-orm-mybatis.md) | 展示 Spring Boot 中集成 MyBatis, 分页插件 PageHelper, 通用 Mapper。 |
| [SpringBoot 教程之访问 MongoDB](data/sbe-data-mongodb.md)                                       | 展示 Spring Boot 中访问 mongodb 。                                  |
| [SpringBoot 教程之访问 Elasticsearch](data/sbe-data-elasticsearch.md)                           | 展示 Spring Boot 中访问 elasticsearch 。                            |
