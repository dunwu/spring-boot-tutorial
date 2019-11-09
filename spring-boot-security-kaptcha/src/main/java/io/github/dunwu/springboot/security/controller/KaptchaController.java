package io.github.dunwu.springboot.security.controller;

import io.github.dunwu.springboot.security.util.KaptchaUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019/10/9
 */
@RestController
@RequestMapping("code")
public class KaptchaController {

	@GetMapping(value = "image")
	public void authImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		// 生成随机字串
		KaptchaUtil.Kaptcha kaptcha = KaptchaUtil.create(60);
		// 存入会话session
		HttpSession session = request.getSession(true);
		// 删除以前的
		session.removeAttribute("code");
		session.removeAttribute("expireTime");
		session.setAttribute("code", kaptcha.getCode());
		session.setAttribute("expireTime", kaptcha.getExpireTime());
		OutputStream out = response.getOutputStream();
		KaptchaUtil.toOutputStream(kaptcha, out);
	}

}
