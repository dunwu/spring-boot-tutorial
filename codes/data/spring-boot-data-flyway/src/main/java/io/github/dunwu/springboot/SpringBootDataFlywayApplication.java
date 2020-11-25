package io.github.dunwu.springboot;

import io.github.dunwu.springboot.data.User;
import io.github.dunwu.springboot.data.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootDataFlywayApplication implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final UserDao userDAO;

    public SpringBootDataFlywayApplication(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataFlywayApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<User> list = userDAO.list();
        list.forEach(user -> {
            log.info(user.toString());
        });
    }

}
