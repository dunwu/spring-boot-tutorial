package io.github.dunwu.springboot;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zhang Peng
 * @date 2019-01-07
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository customerRepository;

    @RequestMapping(value = "/user/list")
    public ResponseDTO<User> list() {
        Iterable<User> all = customerRepository.findAll();
        List<User> list = IteratorUtils.toList(all.iterator());
        return new ResponseDTO<>(list.size(), list);
    }

    @RequestMapping(value = "/user/save")
    public void save(@RequestParam("id")  Long id,User user) {
        user.setId(id);
        customerRepository.save(user);
    }

}
