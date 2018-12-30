package io.github.dunwu.springboot;

import io.github.dunwu.springboot.dto.InfoDTO;
import io.github.dunwu.springboot.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class JsonController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/success")
    public ResponseDTO success() {
        InfoDTO systemInfoDTO = new InfoDTO();
        systemInfoDTO.setAppName("JSON测试应用");
        systemInfoDTO.setVersion("1.0.0");
        return new ResponseDTO(CodeEn.SUCCESS.code(), CodeEn.SUCCESS.message(), new Date(), systemInfoDTO);
    }

    @RequestMapping("/exception")
    public ResponseDTO exception() {
        throw new AppException("一个未知错误");
    }

    @RequestMapping("/exception2")
    public ResponseDTO exception2() {
        int num = 10 / 0;
        return new ResponseDTO(CodeEn.SUCCESS.code(), CodeEn.SUCCESS.message(), new Date(), num);
    }
}
