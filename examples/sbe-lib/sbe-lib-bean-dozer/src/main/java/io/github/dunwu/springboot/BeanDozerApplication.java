package io.github.dunwu.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BeanDozerApplication {

	private static final Logger log = LoggerFactory.getLogger(BeanDozerApplication.class);

	@Autowired
	BeanUtil beanUtil;

	public static void main(String[] args) {
		SpringApplication.run(BeanDozerApplication.class, args);
	}

	@PostConstruct
	public void postConstruct() {
		mapperDemo1();
		mapperDemo2();
	}

	void mapperDemo1() {
		UserDO userDO = new UserDO();
		userDO.setId(1L);
		userDO.setName("userA");
		UserDTO userDTO = beanUtil.map(userDO, UserDTO.class);
		log.info("UserBO: {}", userDTO.toString());
	}

	void mapperDemo2() {
		PersonDO personDO = new PersonDO();
		personDO.setId(1L);
		personDO.setInfo("RULE");
		PersonDTO personDTO = beanUtil.map(personDO, PersonDTO.class);
		log.info("PersonBO: {}", personDTO.toString());
	}

}
