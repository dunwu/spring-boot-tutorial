package io.github.dunwu.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class DataJdbcApplication implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public DataJdbcApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(DataJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DataSource dataSource = jdbcTemplate.getDataSource();
		if (dataSource != null && dataSource.getConnection() != null) {
			log.info("Database is connected.");
		}
	}

}
