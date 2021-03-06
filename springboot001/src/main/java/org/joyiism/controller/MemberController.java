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
import org.joyiism.dto.MemberDTO;
import org.joyiism.service.MemberService;
import org.joyiism.util.AttachfileUtil;
import org.joyiism.util.BCryptEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@ResponseBody
	@RequestMapping(value="add", method=RequestMethod.POST)
	public Map<String, Object> regist(Member member, String mpwdConfirm) {
		logger.info("execute member add controller");
		
		Map<String, Object> jsonData = new HashMap<>();
		try {
			member.setMpwd(BCryptEncoder.encode(member.getMpwd()));
			member.setMphoto(BASE_MPHOTO);
			member.setMsessionKey("none");
			memberService.add(member, mpwdConfirm);
		} catch (Exception e) {
			logger.error("error member add controller", e);
			String errMsg = e.getMessage();
			jsonData.put("err", true);
			if("ERR_PASS".equals(errMsg) || "ERR_NAME".equals(errMsg)
					|| "ERR_EMAIL".equals(errMsg)) {
				jsonData.put("errMsg", errMsg);
			}
		}
		return jsonData;
	}
	
	@ResponseBody @Transactional
	@RequestMapping(value="login", method=RequestMethod.POST)
	public Map<String, Object> login(MemberDTO login, HttpSession session,
			HttpServletResponse response) {
		logger.info("execute member login controller");
	
		Map<String, Object> jsonData = new HashMap<>();
		try {
			MemberDTO loginMember = memberService.exist(login);
			
			if(loginMember != null) {
				logger.info("new login success");
				session.setAttribute("loginMember", loginMember);

				if(login.isUseCookie()) {
					logger.info("remember me.");
					Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * EXPIRY));
					memberService.keepLogin(session.getId(), sessionLimit, loginMember.getMid());
					
					Cookie loginCookie = new Cookie("loginCookie", session.getId());
					loginCookie.setPath("/");
					loginCookie.setMaxAge(EXPIRY);
					response.addCookie(loginCookie);	
				}
			} else {
				jsonData.put("err", true);
			}
		} catch (Exception e) {
			logger.error("error member login controller", e);
			jsonData.put("err", true);
		}
		return jsonData;
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public void logout(HttpServletRequest request, 
			HttpServletResponse response, HttpSession session) {
		logger.info("execute logout controller");
	
		try {
			MemberDTO loginMember = (MemberDTO)session.getAttribute("loginMember");
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
	@RequestMapping(value="updateProfile", method=RequestMethod.POST)
	public Map<String, Object> update(Member member, String mpwdConfirm, HttpSession session) {
		logger.info("execute member update profile controller");
		
		Map<String, Object> jsonData = new HashMap<>();
		try {
			memberService.updateProfile(member, mpwdConfirm, session);
		} catch (Exception e) {
			logger.error("error member update profile controller", e);
			String errMsg = e.getMessage();
			jsonData.put("err", true);
			if("ERR_PASS".equals(errMsg) || "ERR_EMAIL".equals(errMsg)) {
				jsonData.put("errMsg", errMsg);
			}
		}
		return jsonData;
	}
	
	@ResponseBody
	@RequestMapping(value="updateImage", method=RequestMethod.POST)
	public String updateImage(MultipartFile file, HttpSession session) {
		logger.info("execute member update image controller");
		
		String errMsg = null;
		MemberDTO loginMember = (MemberDTO)session.getAttribute("loginMember");
		String mphoto = loginMember.getMphoto();		
		File path = new File(STATIC_ROOT + "/attachfile");

		try {
			String savedDir = AttachfileUtil.uploadImageFile(
				path.getAbsolutePath(), file.getBytes(), "member",
				!mphoto.equals(BASE_MPHOTO) ? mphoto : file.getOriginalFilename())
			.get("imagePath");
			
			if(!savedDir.equals(mphoto)) {
				memberService.updateImage(savedDir, loginMember.getMno());
				
				loginMember.setMphoto(savedDir);
				session.setAttribute("loginMember", loginMember);
			}
		} catch (Exception e) {
			logger.error("error memger update image", e);
			errMsg = e.getMessage();
		}
		return errMsg;
	}
	
	@ResponseBody
	@RequestMapping(value="updatePwd", method=RequestMethod.POST)
	public Map<String, Object> updatePwd(String curPwd, String newPwd, String cPwd, HttpSession session) {
		logger.info("execute member update password controller");

		Map<String, Object> jsonData = new HashMap<>();
		try {
			memberService.updatePwd(curPwd, newPwd, cPwd, session);
		} catch (Exception e) {
			logger.error("error member update password controller", e);
			String errMsg = e.getMessage();
			jsonData.put("err", true);
			if("ERR_PASS".equals(errMsg)) {
				jsonData.put("errMsg", errMsg);
			}
		}
		return jsonData;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteImage", method=RequestMethod.GET)
	public void deleteImage(HttpSession session) {
		logger.info("execute member delete image controller");
		
		try {
			MemberDTO loginMember = (MemberDTO)session.getAttribute("loginMember");
			String mphoto = loginMember.getMphoto();
			
			if(!mphoto.equals(BASE_MPHOTO)) {
				AttachfileUtil.deleteFile(STATIC_ROOT + loginMember.getMphoto());
				memberService.updateImage(BASE_MPHOTO, loginMember.getMno());
			}
			
			loginMember.setMphoto(BASE_MPHOTO);
			session.setAttribute("loginMember", loginMember);
		} catch (Exception e) {
			logger.error("error member delete image controller", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public Map<String, Object> delete(String mpwd, String mpwdConfirm,
			HttpSession session, HttpServletResponse response) {
		logger.info("execute member delete controller");
		
		Map<String, Object> jsonData = new HashMap<>();
		try {
			memberService.delete(mpwd, mpwdConfirm, session);
		} catch (Exception e) {
			logger.error("error member delete controller", e);
			jsonData.put("err", true);
			String errMsg = e.getMessage();
			if("ERR_PASS".equals(errMsg)) {
				jsonData.put("errMsg", errMsg);
			}
		}
		return jsonData;
	}
}
