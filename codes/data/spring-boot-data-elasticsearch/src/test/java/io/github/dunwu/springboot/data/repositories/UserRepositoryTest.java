package io.github.dunwu.springboot.data.repositories;

import io.github.dunwu.springboot.data.entities.User;
import io.github.dunwu.springboot.data.entities.UserQuery;
import io.github.dunwu.springboot.data.util.QueryFeildToQueryBuilderUtil;
import io.github.dunwu.springboot.SpringBootDataElasticsearchApplication;
import io.github.dunwu.tool.util.RandomUtil;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootDataElasticsearchApplication.class })
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() {
        userRepository.deleteAll();

        userRepository.save(new User("刘备", 32, "xxxxxx", "forbreak@163.com"));
        userRepository.save(new User("关羽", 31, "xxxxxx", "xxxxxxx@163.com"));
        userRepository.save(new User("张飞", 29, "xxxxxx", "123xxx@163.com"));
        userRepository.save(new User("赵云", 26, "xxxxxx", "x23xxxx@163.com"));
    }

    @Test
    public void testCount() {
        long count = userRepository.count();
        assertThat(count).isEqualTo(4L);
    }

    @Test
    public void testSave() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            User user = new User(RandomUtil.randomChineseName(),
                RandomUtils.nextInt(18, 99), RandomUtil.randomString(6, 10),
                RandomUtil.randomEmail());
            users.add(user);
        }
        userRepository.saveAll(users);
        long count = userRepository.count();
        assertThat(count).isEqualTo(1004L);
    }

    @Test
    public void testFind() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            User user = new User(RandomUtil.randomChineseName(), RandomUtils.nextInt(18, 99),
                RandomUtil.randomString(6, 10), RandomUtil.randomEmail());
            users.add(user);
        }
        userRepository.saveAll(users);

        Iterable<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);

        System.out.println("User found with findByUsername(\"张鹏\"):");
        System.out.println("--------------------------------");
        List<User> userList2 = userRepository.findByUsername("鹏");
        assertThat(userList2).isNotEmpty();
        userList2.forEach(System.out::println);

        System.out.println("Users found with findByEmail(\"forbreak@163.com\"):");
        System.out.println("--------------------------------");
        User user = userRepository.findByEmail("forbreak@163.com");
        System.out.println(user);
        assertThat(user).isNotNull();
    }

    @Test
    public void testSearch() throws IllegalAccessException {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            User user = new User(String.valueOf(i), RandomUtil.randomChineseName(), RandomUtils.nextInt(18, 99),
                RandomUtil.randomString(6, 10), RandomUtil.randomEmail());
            users.add(user);
        }
        userRepository.saveAll(users);

        UserQuery userQuery = new UserQuery();
        userQuery.setUsername("张");
        SearchQuery searchQuery = QueryFeildToQueryBuilderUtil.transQueryDto2Condition(userQuery);

        Page<User> page = userRepository.search(searchQuery);
        System.out.println("Total Match: " + page.getTotalElements());
        page.getContent().forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        User user = userRepository.findByEmail("forbreak@163.com");
        System.out.println("Before Update: " + user);
        assertThat(user).isNotNull();

        user.setEmail("modify@modify.com");
        userRepository.deleteById(user.getId());
        userRepository.save(user);
        Optional<User> optional = userRepository.findById(user.getId());
        assertThat(optional).isNotNull();
        assertThat(optional.get().getEmail()).isEqualTo("modify@modify.com");
        assertThat(optional.get().getId()).isEqualTo(user.getId());
        System.out.println("After Update: " + optional.get());
    }

}
