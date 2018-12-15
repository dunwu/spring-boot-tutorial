package io.github.dunwu.springboot;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 同时启动HTTP和HTTPS服务
 * <p>
 * 启动应用后，可访问链接：
 * <ul>
 * <li><a href="http://localhost:8081/hello">http://localhost:8081/hello</a></li>
 * <li><a href="https://localhost:8443/hello">https://localhost:8443/hello</a></li>
 * </ul>
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
