package io.github.dunwu.springboot.controller;

import io.github.dunwu.core.BaseResult;
import io.github.dunwu.core.DataResult;
import io.github.dunwu.core.DefaultAppCode;
import io.github.dunwu.core.ResultUtil;
import io.github.dunwu.springboot.dto.UserInfoDTO;
import io.github.dunwu.springboot.entity.UserDO;
import io.github.dunwu.springboot.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public static final String TOKEN_KEY = "token";

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public DataResult<UserInfoDTO> login(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        UserDO userDO = userService.getByUsername(username);
        if (userDO == null) {
            return ResultUtil.failDataResult(DefaultAppCode.ERROR_AUTH);
        }

        if (userDO.getPassword()
                  .equals(password)) {
            request.getSession()
                   .setAttribute(TOKEN_KEY, request.getSession()
                                                   .getId());
            log.info("session token = {}", request.getSession()
                                                  .getAttribute(TOKEN_KEY));
            Cookie cookie = new Cookie(TOKEN_KEY, request.getSession()
                                                         .getId());
            cookie.setPath("/");
            response.addCookie(cookie);

            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setName("Super Admin");
            userInfoDTO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            userInfoDTO.setIntroduction("I am a super administrator");
            userInfoDTO.getRoles()
                       .add("admin");
            userInfoDTO.setToken(request.getSession()
                                        .getId());
            return ResultUtil.successDataResult(userInfoDTO);
        }
        return ResultUtil.failDataResult(DefaultAppCode.ERROR_AUTH);
    }

    @PostMapping("/logout")
    public BaseResult logout(HttpServletRequest request) {
        request.getSession()
               .removeAttribute(TOKEN_KEY);
        return ResultUtil.successBaseResult();
    }

    @GetMapping("/getInfo")
    public DataResult<UserInfoDTO> getInfo(HttpServletRequest request) {
        String token = (String) request.getSession()
                                       .getAttribute(TOKEN_KEY);
        log.info("session id = {}", request.getSession()
                                           .getId());
        log.info("session token = {}", token);
        if (StringUtils.isBlank(token)) {
            return ResultUtil.failDataResult(DefaultAppCode.ERROR_AUTH);
        }
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setName("Super Admin");
        userInfoDTO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfoDTO.setIntroduction("I am a super administrator");
        userInfoDTO.getRoles()
                   .add("admin");
        userInfoDTO.setToken(request.getSession()
                                    .getId());
        return ResultUtil.successDataResult(userInfoDTO);
    }
}
