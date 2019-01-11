package io.github.dunwu.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataJpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataJpaApplication.class);

    private final UserRepository repository;

    @Autowired
    public DataJpaApplication(UserRepository repository) {this.repository = repository;}

    public static void main(String[] args) {
        SpringApplication.run(DataJpaApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        // save a couple of users
        repository.save(new User(null, "张三", 21, "南京", "xxx@163.com"));
        repository.save(new User(null, "李四", 28, "上海", "xxx@163.com"));
        repository.save(new User(null, "王五", 24, "北京", "xxx@163.com"));
        repository.save(new User(null, "赵六", 31, "广州", "xxx@163.com"));

        // fetch all users
        log.info("Users found with findAll():");
        log.info("-------------------------------");
        for (User user : repository.findAll()) {
            log.info(user.toString());
        }
        log.info("");

        // fetch an individual customer by ID
        repository.findById(1L).ifPresent(user -> {
            log.info("User found with findById(1L):");
            log.info("--------------------------------");
            log.info(user.toString());
            log.info("");
        });

        repository.findByName("李四").ifPresent(user -> {
            log.info("User found with findByName(1L):");
            log.info("--------------------------------");
            log.info(user.toString());
            log.info("");
        });
    }
}
