package io.github.dunwu.springboot.web;

import io.github.dunwu.springboot.dto.CodeEn;
import io.github.dunwu.springboot.dto.InfoDTO;
import io.github.dunwu.springboot.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class JsonController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/exception")
	public ResponseDTO exception() {
		throw new AppException("一个未知错误");
	}

	@RequestMapping("/exception2")
	public ResponseDTO<Integer> exception2() {
		int num = 10 / 0;
		return new ResponseDTO<>(CodeEn.SUCCESS.code(), CodeEn.SUCCESS.message(), new Date(), num);
	}

	@RequestMapping(name = "/postInfo", method = RequestMethod.POST)
	public void postInfo(@RequestBody InfoDTO infoDTO) {
		log.info("infoDTO = [{}]", infoDTO);
	}

	@RequestMapping("/success")
	public ResponseDTO<InfoDTO> success() {
		InfoDTO systemInfoDTO = new InfoDTO();
		systemInfoDTO.setAppName("JSON测试应用");
		systemInfoDTO.setVersion("1.0.0");
		return new ResponseDTO<>(CodeEn.SUCCESS.code(), CodeEn.SUCCESS.message(), new Date(), systemInfoDTO);
	}

	@RequestMapping(name = "/getInfo", method = RequestMethod.GET)
	public InfoDTO getInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		InfoDTO infoDTO = null;
		try {
			infoDTO = new InfoDTO("JSON测试应用", "1.0.0", sdf.parse("2019-01-01 12:00:00"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return infoDTO;
	}

}
