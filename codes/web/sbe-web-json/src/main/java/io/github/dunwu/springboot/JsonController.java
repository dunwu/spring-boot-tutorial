package io.github.dunwu.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @RequestMapping("/success")
    public ResponseDTO success() {
        SystemInfoDTO systemInfoDTO = new SystemInfoDTO();
        systemInfoDTO.setAppName("JSON测试应用");
        systemInfoDTO.setVersion("1.0.0");
        return new ResponseDTO(CodeEn.SUCCESS.code(), CodeEn.SUCCESS.message(), systemInfoDTO);
    }

    @RequestMapping("/exception")
    public ResponseDTO exception() {
        throw new AppException("一个未知错误");
    }

    @RequestMapping("/exception2")
    public ResponseDTO exception2() throws IllegalAccessException {
        int num = 10 / 0;
        return new ResponseDTO(CodeEn.SUCCESS.code(), CodeEn.SUCCESS.message(), num);
    }
}
