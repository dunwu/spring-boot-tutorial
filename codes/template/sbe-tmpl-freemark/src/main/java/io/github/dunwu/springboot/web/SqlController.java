package io.github.dunwu.springboot.web;

import io.github.dunwu.springboot.data.User;
import io.github.dunwu.springboot.data.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zhang Peng
 * @date 2018-12-19
 */
@RestController
@RequestMapping("/sql")
public class SqlController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/list")
    public List<User> list() {
        return userDAO.list();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public void create(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        userDAO.create(name, age);
    }

    @RequestMapping("/deleteByName")
    public void deleteByName(@RequestParam("name") String name) {
        userDAO.deleteByName(name);
    }

    @RequestMapping("/clear")
    public void clear() {
        userDAO.clear();
    }
}
