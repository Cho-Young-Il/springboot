package org.joyiism.controller;

import java.io.File;
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
import org.joyiism.util.AttachfileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

@Controller("MemberController")
@RequestMapping("/member/*")
public class MemberController {
	@Autowired private MemberService memberService;
	private final int EXPIRY = 60 * 60 * 24 * 7;
	private final String STATIC_ROOT = "src/main/resources/static";
	private final String BASE_MPHOTO = "/images/base-user.png";
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberController.class);
	
	@ResponseBody
	@RequestMapping(value="add", method=RequestMethod.POST)
	public void regist(Member member) {
		logger.info("execute member add controller");
		try {
			member.setMpwd(BCryptEncoder.encode(member.getMpwd()));
			member.setMphoto(BASE_MPHOTO);
			member.setMsessionKey("none");
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
			Login loginMember = memberService.exist(login);
			
			if(loginMember != null) {
				logger.info("new login success");
				session.setAttribute("loginMember", loginMember);
				jsonData.put("url", "/board/list");

				if(login.isUseCookie()) {
					logger.info("remember me.");
					Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * EXPIRY));
					memberService.keepLogin(session.getId(), sessionLimit, loginMember.getMid());
					
					Cookie loginCookie = new Cookie("loginCookie", session.getId());
					loginCookie.setPath("/");
					loginCookie.setMaxAge(EXPIRY);
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
			Login loginMember = (Login)session.getAttribute("loginMember");
			if(loginMember != null) {
				session.removeAttribute("loginMember");
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
	
	@ResponseBody
	@RequestMapping(value="loginMember", method=RequestMethod.GET)
	public Login getSession(HttpSession session) {
		logger.info("execute get session controller");
		return (Login)session.getAttribute("loginMember");
	}
	
	@ResponseBody
	@RequestMapping(value="updateImage", method=RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public String updateImage(MultipartFile file, HttpSession session) {
		logger.info("execute member update image controller");
		
		String retString = null;
		Login loginMember = (Login)session.getAttribute("loginMember");
		String mphoto = loginMember.getMphoto();		
		File path = new File(STATIC_ROOT + "/attachfile");

		try {
			String savedDir = AttachfileUtil.uploadImageFile(
				path.getAbsolutePath(), file.getBytes(), "member",
				!mphoto.equals(BASE_MPHOTO) ? mphoto : file.getOriginalFilename())
			.get("imagePath");
			
			if(savedDir.equals(mphoto)) {
				memberService.updateImage(savedDir, loginMember.getMno());
				loginMember.setMphoto(savedDir);
				session.setAttribute("loginMember", loginMember);
			}
		} catch (Exception e) {
			logger.error("error memger update image", e);
			retString = e.getMessage();
		}
		return retString;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteImage", method=RequestMethod.GET)
	public void deleteImage(HttpSession session) {
		logger.info("execute member delete image controller");
		
		try {
			Login loginMember = (Login)session.getAttribute("loginMember");
			AttachfileUtil.deleteFile(STATIC_ROOT + loginMember.getMphoto());
			memberService.updateImage(BASE_MPHOTO, loginMember.getMno());
			loginMember.setMphoto(BASE_MPHOTO);
			session.setAttribute("loginMember", loginMember);
		} catch (Exception e) {
			logger.error("error member delete image controller", e);
		}
	}
}
