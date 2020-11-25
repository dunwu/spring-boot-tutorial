package io.github.dunwu.springboot;

import io.github.dunwu.springboot.data.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

@SpringBootApplication
public class SpringBootDataJdbcMultiDataSourceApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootDataJdbcMultiDataSourceApplication.class);

    private final UserDao mysqlUserDao;

    private final UserDao h2UserDao;

    public SpringBootDataJdbcMultiDataSourceApplication(@Qualifier("mysqlUserDao") UserDao mysqlUserDao,
        @Qualifier("h2UserDao") UserDao h2UserDao) {
        this.mysqlUserDao = mysqlUserDao;
        this.h2UserDao = h2UserDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataJdbcMultiDataSourceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (mysqlUserDao != null && mysqlUserDao.getJdbcTemplate() != null) {
            printDataSourceInfo(mysqlUserDao.getJdbcTemplate());
            log.info("连接 Mysql 数据库成功");
        } else {
            log.error("连接 Mysql 数据库失败");
            return;
        }

        if (h2UserDao != null) {
            printDataSourceInfo(h2UserDao.getJdbcTemplate());
            log.info("连接 H2 数据库成功");
        } else {
            log.error("连接 H2 数据库失败");
            return;
        }

        // 主数据源执行 JDBC SQL
        mysqlUserDao.recreateTable();

        // 次数据源执行 JDBC SQL
        h2UserDao.recreateTable();
    }

    private void printDataSourceInfo(JdbcTemplate jdbcTemplate) throws SQLException {

        DataSource dataSource = jdbcTemplate.getDataSource();

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
