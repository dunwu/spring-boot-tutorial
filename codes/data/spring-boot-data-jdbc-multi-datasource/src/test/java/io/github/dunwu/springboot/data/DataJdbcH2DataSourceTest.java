package io.github.dunwu.springboot.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootDataJdbcMultiDataSourceApplication.class })
public class DataJdbcH2DataSourceTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("h2UserDao")
    private UserDao userDAO;

    @Before
    public void before() {
        userDAO.recreateTable();
    }

    @Test
    public void insert() {
        userDAO.insert(new User("张三", 18, "北京", "user1@163.com"));
        User linda = userDAO.queryByName("张三");
        assertThat(linda).isNotNull();
    }

    @Test
    public void batchInsert() {
        List<User> users = new ArrayList<>();
        users.add(new User("张三", 18, "北京", "user1@163.com"));
        users.add(new User("李四", 19, "上海", "user1@163.com"));
        users.add(new User("王五", 18, "南京", "user1@163.com"));
        users.add(new User("赵六", 20, "武汉", "user1@163.com"));

        userDAO.batchInsert(users);
        int count = userDAO.count();
        assertThat(count).isEqualTo(4);

        List<User> list = userDAO.list();
        assertThat(list).isNotEmpty().hasSize(4);
        list.forEach(user -> {
            log.info(user.toString());
        });
    }

    @Test
    public void delete() {
        List<User> users = new ArrayList<>();
        users.add(new User("张三", 18, "北京", "user1@163.com"));
        users.add(new User("李四", 19, "上海", "user1@163.com"));
        users.add(new User("王五", 18, "南京", "user1@163.com"));
        users.add(new User("赵六", 20, "武汉", "user1@163.com"));
        userDAO.batchInsert(users);

        userDAO.deleteByName("张三");
        User user = userDAO.queryByName("张三");
        assertThat(user).isNull();

        userDAO.deleteAll();
        List<User> list = userDAO.list();
        assertThat(list).isEmpty();
    }

    @Test
    public void update() {
        userDAO.insert(new User("张三", 18, "北京", "user1@163.com"));
        User oldUser = userDAO.queryByName("张三");
        oldUser.setName("张三丰");
        userDAO.update(oldUser);
        User newUser = userDAO.queryByName("张三丰");
        assertThat(newUser).isNotNull();
    }

}
