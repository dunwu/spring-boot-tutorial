package io.github.dunwu.springboot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.github.dunwu.springboot.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserDAO userDAO;

    @Before
    public void before() {
        // 准备，清空user表
        userDAO.deleteAllUsers();
    }

    @Test
    public void test() {
        // 插入5个用户
        userDAO.create("a", 1);
        userDAO.create("b", 2);
        userDAO.create("c", 3);
        userDAO.create("d", 4);
        userDAO.create("e", 5);

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userDAO.getAllUsers().intValue());

        // 删除两个用户
        userDAO.deleteByName("a");
        userDAO.deleteByName("e");

        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userDAO.getAllUsers().intValue());
    }
}
