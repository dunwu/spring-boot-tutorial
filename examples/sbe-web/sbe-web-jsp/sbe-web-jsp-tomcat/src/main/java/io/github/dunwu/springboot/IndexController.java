package io.github.dunwu.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Map<String, Object> model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		model.put("time", sdf.format(new Date()));
		return "index";
	}

}
