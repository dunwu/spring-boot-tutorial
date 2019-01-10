package io.github.dunwu.springboot;

import java.util.List;

public interface UserDAO {

    void recreateTable();

    void batchInsert(List<User> users);

    void insert(String name, Integer age);

    void delete(String name);

    void update(User user);

    Integer count();

    User queryByName(String name);

    List<User> list();
}
