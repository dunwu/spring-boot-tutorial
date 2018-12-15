package io.github.dunwu.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {

    @Value("${io.github.dunwu.springboot.blog.name}")
    private String name;
    @Value("${io.github.dunwu.springboot.blog.title}")
    private String title;
    @Value("${io.github.dunwu.springboot.blog.desc}")
    private String desc;

    @Value("${io.github.dunwu.springboot.blog.value}")
    private String value;
    @Value("${io.github.dunwu.springboot.blog.number}")
    private Integer number;
    @Value("${io.github.dunwu.springboot.blog.bignumber}")
    private Long bignumber;
    @Value("${io.github.dunwu.springboot.blog.test1}")
    private Integer test1;
    @Value("${io.github.dunwu.springboot.blog.test2}")
    private Integer test2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getBignumber() {
        return bignumber;
    }

    public void setBignumber(Long bignumber) {
        this.bignumber = bignumber;
    }

    public Integer getTest1() {
        return test1;
    }

    public void setTest1(Integer test1) {
        this.test1 = test1;
    }

    public Integer getTest2() {
        return test2;
    }

    public void setTest2(Integer test2) {
        this.test2 = test2;
    }
}
