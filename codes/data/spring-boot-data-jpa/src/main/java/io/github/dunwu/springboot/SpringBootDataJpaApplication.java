package io.github.dunwu.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final DataSource dataSource;

    public SpringBootDataJpaApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (dataSource != null) {
            printDataSourceInfo(dataSource);
            log.info("连接数据源成功");
        } else {
            log.error("连接数据源失败");
        }
    }

    private void printDataSourceInfo(DataSource dataSource) throws SQLException {

        Connection connection;
        if (dataSource != null) {
            connection = dataSource.getConnection();
        } else {
            log.error("连接数据库失败");
            return;
        }

        if (connection != null) {
            log.info("数据源 URL: {}", connection.getMetaData().getURL());
        } else {
            log.error("连接数据库失败");
        }
    }

}
