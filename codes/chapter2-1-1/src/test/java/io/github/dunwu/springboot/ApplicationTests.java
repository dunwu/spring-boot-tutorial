package io.github.dunwu.springboot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.dunwu.springboot.service.BlogProperties;


/**
 *
 * @author Zhang Peng
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private static final Log log = LogFactory.getLog(ApplicationTests.class);

    @Autowired
    private BlogProperties blogProperties;


    @Test
    public void test1() throws Exception {
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
