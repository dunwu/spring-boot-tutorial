package io.github.dunwu.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DataFlywayApplication implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final UserDao userDAO;

	public DataFlywayApplication(UserDao userDAO) {
		this.userDAO = userDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(DataFlywayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<User> list = userDAO.list();
		list.forEach(user -> {
			log.info(user.toString());
		});
	}

}
