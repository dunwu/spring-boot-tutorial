package io.github.dunwu.springboot.security.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019/10/8
 */
@Component
public class ValidateCodeFilter extends OncePerRequestFilter {

	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {
		if (StringUtils.equalsIgnoreCase("/login", httpServletRequest.getRequestURI())
				&& StringUtils.equalsIgnoreCase(httpServletRequest.getMethod(), "post")) {

			try {
				check(httpServletRequest);
			}
			catch (ValidateCodeException e) {
				authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
			}

		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

	private void check(HttpServletRequest httpServletRequest) throws ValidateCodeException {

		HttpSession session = httpServletRequest.getSession();
		String code = (String) session.getAttribute("code");
		LocalDateTime expireTime = (LocalDateTime) session.getAttribute("expireTime");
		String kaptchaCode = httpServletRequest.getParameter("kaptchaCode");

		if (StringUtils.isBlank(kaptchaCode)) {
			throw new ValidateCodeException("验证码不能为空！");
		}

		if (StringUtils.isBlank(code)) {
			throw new ValidateCodeException("验证码不存在！");
		}

		if (expireTime == null || expireTime.isBefore(LocalDateTime.now())) {
			throw new ValidateCodeException("验证码已过期！");
		}

		if (!StringUtils.equalsIgnoreCase(code, kaptchaCode)) {
			throw new ValidateCodeException("验证码不正确！");
		}
	}

}
