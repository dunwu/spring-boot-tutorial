package io.github.dunwu.springboot;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FailController {

    @RequestMapping("/fail")
    public String fail() {
        throw new IllegalStateException("this endpoint always fail");
    }

}
