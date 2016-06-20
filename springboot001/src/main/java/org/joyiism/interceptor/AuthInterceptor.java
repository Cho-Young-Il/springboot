package org.joyiism.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joyiism.dto.LoginDTO;
import org.joyiism.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Autowired private MemberService memberService;
	private final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("execute auth interceptor");
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			logger.info("current login member is not logined");
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie != null) {
				LoginDTO member = memberService.checkLoginBefore(loginCookie.getValue());
				logger.info("Member : " + member);
				
				if(member != null) {
					session.setAttribute("loginMember", member);
					return true;
				}
			}
			response.sendRedirect("/");
			return false;
		}
		return true;
	}
}
