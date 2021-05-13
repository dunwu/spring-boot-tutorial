package io.github.dunwu.springboot;

import io.github.dunwu.springboot.data.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019-10-16
 */
@SpringBootApplication
@MapperScan("io.github.dunwu.springboot.data.mapper")
public class SpringBootDataMybatisShardingApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootDataMybatisShardingApplication.class);

    private final UserMapper userMapper;

    public SpringBootDataMybatisShardingApplication(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataMybatisShardingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (userMapper == null) {
            log.error("连接数据源失败");
            return;
        } else {
            log.info("连接数据源成功");
        }
    }

}
