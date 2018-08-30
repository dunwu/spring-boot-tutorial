package io.github.dunwu.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.dunwu.springboot.service.BlogProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicProfileApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(BasicProfileApplicationTests.class);

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void test1() {
        Assert.assertEquals("Zhang Peng", blogProperties.getName());
        Assert.assertEquals("Spring Boot 教程", blogProperties.getTitle());
        Assert.assertEquals("Zhang Peng 正在努力写 《Spring Boot 教程》", blogProperties.getDesc());

        log.info("随机数测试输出：");
        log.info("随机字符串 : " + blogProperties.getValue());
        log.info("随机int : " + blogProperties.getNumber());
        log.info("随机long : " + blogProperties.getBignumber());
        log.info("随机10以下 : " + blogProperties.getTest1());
        log.info("随机10-20 : " + blogProperties.getTest2());

    }

}
