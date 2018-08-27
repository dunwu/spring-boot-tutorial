package io.github.dunwu.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.dunwu.springboot.rabbit.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void hello() {
        sender.send();
    }

}
