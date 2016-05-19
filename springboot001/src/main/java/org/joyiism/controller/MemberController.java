package org.joyiism.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joyiism.domain.Member;
import org.joyiism.dto.Login;
import org.joyiism.service.MemberService;
import org.joyiism.util.BCryptEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

@Controller("MemberController")
@RequestMapping("/member/*")
public class MemberController {
	@Autowired private MemberService memberService;
	private final int expiry = 60 * 60 * 24 * 7;
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberController.class);
	
	@ResponseBody
	@RequestMapping(value="add", method=RequestMethod.POST)
	public void regist(Member member) {
		logger.info("execute member add controller");
		try {
			member.setMpwd(BCryptEncoder.encode(member.getMpwd()));
			memberService.add(member);
		} catch (Exception e) {
			logger.error("error member add controller", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="login", method=RequestMethod.POST)
	public Map<String, Object> login(Login login, HttpSession session,
			HttpServletResponse response) {
		logger.info("execute member login controller");
		Map<String, Object> jsonData = new HashMap<>();
		try {
			Member loginMember = memberService.exist(login);
			if(loginMember != null) {
				logger.info("new login success");
				session.setAttribute("loginMember", loginMember);
				jsonData.put("url", "/board/list");

				if(login.isUseCookie()) {
					logger.info("remember me.");
					Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * expiry));
					memberService.keepLogin(session.getId(), sessionLimit, loginMember.getMid());
					
					Cookie loginCookie = new Cookie("loginCookie", session.getId());
					loginCookie.setPath("/");
					loginCookie.setMaxAge(expiry);
					response.addCookie(loginCookie);	
				}
			}
		} catch (Exception e) {
			logger.error("error member login controller", e);
		}
		return jsonData;
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public void logout(HttpServletRequest request, 
			HttpServletResponse response, HttpSession session) {
		logger.info("execute logout controller");
		try {
			Member loginMember = (Member)session.getAttribute("loginMember");
			if(loginMember != null) {
				session.removeAttribute("login");
				session.invalidate();
				
				Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
				if(loginCookie != null) {
					loginCookie.setPath("/");
					loginCookie.setMaxAge(0);
					response.addCookie(loginCookie);
					memberService.keepLogin(session.getId(), new Date(), loginMember.getMid());
				}
			}
			response.sendRedirect("/");
		} catch (Exception e) {
			logger.error("error logout controller", e);
		}
	}
}
