package io.github.dunwu.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class DataJdbcMultiConnectorsApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DataJdbcMultiConnectorsApplication.class);

	@Qualifier("mysqlUserDao")
	private final UserDao mysqlUserDao;

	@Qualifier("h2UserDao")
	private final UserDao h2UserDao;

	public DataJdbcMultiConnectorsApplication(UserDao mysqlUserDao, UserDao h2UserDao) {
		this.mysqlUserDao = mysqlUserDao;
		this.h2UserDao = h2UserDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(DataJdbcMultiConnectorsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (mysqlUserDao != null && mysqlUserDao.getJdbcTemplate() != null) {
			printDataSourceInfo(mysqlUserDao.getJdbcTemplate());
			log.info("连接主数据源成功！");
		} else {
			log.error("连接主数据源失败！");
			return;
		}

		if (h2UserDao != null) {
			printDataSourceInfo(h2UserDao.getJdbcTemplate());
			log.info("连接次数据源成功！");
		} else {
			log.error("连接次数据源失败！");
			return;
		}

		// 主数据源执行 JDBC SQL
		mysqlUserDao.recreateTable();

		// 次数据源执行 JDBC SQL
		h2UserDao.recreateTable();
	}

	public void printDataSourceInfo(JdbcTemplate jdbcTemplate) throws SQLException {

		DataSource dataSource = jdbcTemplate.getDataSource();

		Connection connection;
		if (dataSource != null) {
			connection = dataSource.getConnection();
		} else {
			log.error("获取 DataSource 失败");
			return;
		}

		if (connection != null) {
			log.info("DB URL: {}", connection.getMetaData().getURL());
		} else {
			log.error("获取 Connection 失败");
		}
	}

}
