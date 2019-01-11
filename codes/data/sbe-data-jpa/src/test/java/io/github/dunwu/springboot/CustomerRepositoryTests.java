package io.github.dunwu.springboot;

import org.apache.commons.collections4.IterableUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Before
    public void before() {
        repository.deleteAll();
    }

    @Test
    public void add() {
        repository.save(new User(null, "张三", 21, "南京", "xxx@163.com"));
        repository.save(new User(null, "李四", 28, "上海", "xxx@163.com"));
        repository.save(new User(null, "王五", 24, "北京", "xxx@163.com"));
        repository.save(new User(null, "赵六", 31, "广州", "xxx@163.com"));
        Assert.assertEquals(4L, repository.count());

        Iterable<User> iterable = repository.findAll();
        List<User> users = IterableUtils.toList(iterable);
        Assert.assertEquals(4, users.size());

        System.out.println("user list: ");
        users.forEach(item -> {
            System.out.println(item);
        });
    }

    @Test
    public void delete() {
        User user = repository.save(new User(null, "张三", 21, "南京", "xxx@163.com"));
        Optional<User> result1 = repository.findByName(user.getName());
        Assert.assertNotNull(result1);
        Assert.assertNotNull(result1.get());

        repository.delete(user);
        Optional<User> result2 = repository.findByName(user.getName());
        if (result2 == null) {
            Assert.fail();
        }
    }

    @Test
    public void update() {
        User user = repository.save(new User(null, "李四", 28, "上海", "xxx@163.com"));
        user.setName("lisi");
        repository.save(user);

        Optional<User> result = repository.findByName("lisi");
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.get());
    }

    @Test
    public void findAll() {
        repository.save(new User(null, "张三", 21, "南京", "xxx@163.com"));
        repository.save(new User(null, "李四", 28, "上海", "xxx@163.com"));
        repository.save(new User(null, "王五", 24, "北京", "xxx@163.com"));
        repository.save(new User(null, "赵六", 31, "广州", "xxx@163.com"));

        Iterable<User> iterable = repository.findAll();
        List<User> users = IterableUtils.toList(iterable);
        if (users == null || users.size() != 4) {
            Assert.fail();
        } else {
            System.out.println("user list: ");
            users.forEach(item -> {
                System.out.println(item);
            });
        }
    }

    @Test
    public void findAllInPage() {
        repository.save(new User(null, "张三", 21, "南京", "xxx@163.com"));
        repository.save(new User(null, "李四", 28, "上海", "xxx@163.com"));
        repository.save(new User(null, "王五", 24, "北京", "xxx@163.com"));
        repository.save(new User(null, "赵六", 31, "广州", "xxx@163.com"));

        PageRequest pageRequest = PageRequest.of(1, 2);
        Page<User> page = repository.findAll(pageRequest);
        if (page == null) {
            Assert.fail();
        } else {
            page.getTotalElements();
            Assert.assertEquals(4, page.getTotalElements());
            Assert.assertEquals(2, page.getTotalPages());
            List<User> users = page.get().collect(Collectors.toList());
            System.out.println("user list: ");
            users.forEach(item -> {
                System.out.println(item);
            });
        }
    }
}
