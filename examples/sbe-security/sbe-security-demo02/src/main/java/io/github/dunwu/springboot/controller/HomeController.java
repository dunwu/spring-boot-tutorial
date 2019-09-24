package io.github.dunwu.springboot.controller;

import io.github.dunwu.springboot.entity.UserDO;
import io.github.dunwu.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping({"/", "/index", "/home"})
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(UserDO userDO) {
        userService.insert(encryptPassword(userDO));
        return "redirect:register?success";
    }

    /**
     * 对注册密码进行加密
     */
    private UserDO encryptPassword(UserDO userDO) {
        String password = new BCryptPasswordEncoder().encode(userDO.getPassword());
        userDO.setPassword(password);
        return userDO;
    }
}
