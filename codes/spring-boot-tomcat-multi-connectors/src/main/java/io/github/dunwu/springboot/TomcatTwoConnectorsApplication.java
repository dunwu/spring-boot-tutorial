package io.github.dunwu.springboot;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 同时启动HTTP和HTTPS服务<br>
 * 可访问链接：<br>
 * http://localhost:84081/hello<br>
 * https://localhost:8443/hello
 */
@SpringBootApplication
public class TomcatTwoConnectorsApplication {
    @Value("${http.port:8080}")
    private int httpPort;

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(httpPort);
        return connector;
    }

    public static void main(String[] args) {
        SpringApplication.run(TomcatTwoConnectorsApplication.class, args);
    }

}
