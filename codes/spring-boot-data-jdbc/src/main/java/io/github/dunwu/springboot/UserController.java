package io.github.dunwu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Zhang Peng
 * @date 2018-12-15
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @ResponseBody
    @RequestMapping(path = "/clear")
    public String clear() {
        userDAO.deleteAllUsers();
        return "clear success";
    }

    @ResponseBody
    @RequestMapping(path = "/create")
    public String create(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        userDAO.create(name, age);
        return "create success";
    }

    @RequestMapping(path = "/delete")
    public String delete(@RequestParam("name") String name) {
        userDAO.deleteByName(name);
        return "delete success";
    }

    @ResponseBody
    @RequestMapping(path = "/list")
    public List<User> list() {
        return userDAO.list();
    }
}
