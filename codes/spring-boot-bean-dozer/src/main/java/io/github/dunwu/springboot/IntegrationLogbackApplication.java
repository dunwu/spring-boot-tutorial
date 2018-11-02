package io.github.dunwu.springboot;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.spring.DozerBeanMapperFactoryBean;
import io.github.dunwu.springboot.dozer.PersonBO;
import io.github.dunwu.springboot.dozer.PersonDO;
import io.github.dunwu.springboot.dozer.UserBO;
import io.github.dunwu.springboot.dozer.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class IntegrationLogbackApplication {

    private static final Logger logger = LoggerFactory.getLogger(IntegrationLogbackApplication.class);

    @Autowired DozerBeanMapperFactoryBean factoryBean;

    void mapperDemo1() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("userA");
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        UserBO userBO = mapper.map(userDO, UserBO.class);
        System.out.println(userBO.toString());
    }

    void mapperDemo2() {
        Mapper dozerMapper = factoryBean.getObject();
        PersonDO personDO = new PersonDO();
        personDO.setId(1L);
        personDO.setInfo("RULE");
        PersonBO ruleBO = dozerMapper.map(personDO, PersonBO.class, "RuleBO2RuleDMO");
        System.out.println(ruleBO.toString());
    }

    @PostConstruct
    public void postConstruct() {
        mapperDemo1();
        mapperDemo2();
    }

    public static void main(String[] args) {
        SpringApplication.run(IntegrationLogbackApplication.class, args).close();
    }

}
