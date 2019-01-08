# SpringBootTutorial :: Lib :: Log :: Log4j

> Spring Boot + Slf4j + Log4j

## 添加依赖

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter</artifactId>
  <exclusions>
    <exclusion>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-logging</artifactId>
    </exclusion>
  </exclusions>
</dependency>
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-api</artifactId>
</dependency>
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-log4j12</artifactId>
</dependency>
```

## log4j.xml 配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
<log4j:configuration xmlns:log4j='http://jakarta.apache.org/log4j/'>
  <appender name="CONSOLE-APPENDER" class="org.apache.log4j.ConsoleAppender">
    <layout class="org.apache.log4j.PatternLayout">
      <param name="ConversionPattern" value="%d{yyyy-MM-dd HH:mm:ss,SSS\} [%-5p] [%t] %c{36\}.%M - %m%n"/>
    </layout>
    <filter class="org.apache.log4j.varia.LevelRangeFilter">
      <param name="levelMin" value="trace"/>
      <param name="levelMax" value="error"/>
      <param name="AcceptOnMatch" value="true"/>
    </filter>
  </appender>
  <appender name="ALL-APPENDER" class="org.apache.log4j.DailyRollingFileAppender">
    <param name="File" value="logs/spring-boot-integration-log4j.log"/>
    <param name="Append" value="true"/>
    <param name="DatePattern" value="'.'yyyy-MM-dd'.log'"/>
    <layout class="org.apache.log4j.PatternLayout">
      <param name="ConversionPattern" value="%d{yyyy-MM-dd HH:mm:ss,SSS\} [%-5p] [%t] %c{36\}.%M - %m%n"/>
    </layout>
    <filter class="org.apache.log4j.varia.LevelRangeFilter">
      <param name="AcceptOnMatch" value="true"/>
    </filter>
  </appender>

  <logger name="io.github.dunwu.springboot" additivity="false">
    <appender-ref ref="ALL-APPENDER"/>
  </logger>

  <root>
    <appender-ref ref="CONSOLE-APPENDER"/>
  </root>
</log4j:configuration>
```

## 使用 Slf4j API

```java
public class WebLogAspect {

    private Logger logger = Logger.getLogger(getClass());

    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }
}
```
