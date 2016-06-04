package org.joyiism.service.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.joyiism.dao.MemberDao;
import org.joyiism.domain.Member;
import org.joyiism.dto.Login;
import org.joyiism.service.MemberService;
import org.joyiism.util.BCryptEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDao memberDao;
	private Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	private final String NAME_REGEX = "[가-힣]{2,4}|[a-zA-Z]{3,20}";
	private final String EMAIL_REGEX = "([\\w-]+(?:\\.[\\w-]+)*)@"
			+ "((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)";
	
	@Override
	public void add(Member member, String mpwdConfirm) throws Exception {
		logger.info("execute member insert"); 
		
		String encodedPass = member.getMpwd();
		if(!BCryptEncoder.matches(mpwdConfirm, encodedPass)) {
			throw new Exception("ERR_PASS");
		} else if(!member.getMname().matches(NAME_REGEX)) {
			throw new Exception("ERR_NAME");
		} else if(!member.getMemail().matches(EMAIL_REGEX)) {
			throw new Exception("ERR_EMAIL");
		} else {
			memberDao.save(member);			
		}
	}
	
	@Override
	public Login exist(Login login) throws Exception {
		logger.info("check member exist");
		
		Member member = memberDao.findByMid(login.getMid());
		if(member != null && BCryptEncoder.matches(login.getMpwd(), member.getMpwd())) {
			return new Login(member);
		}
		return null;
	}
	
	@Override
	public void keepLogin(String msessionKey, Date next, String mid) throws Exception {
		logger.info("execute keep login method : member service");
		
		memberDao.keepLogin(msessionKey, next, mid);
	}
	
	@Override
	public Login checkLoginBefore(String value) throws Exception {
		logger.info("execute check member width sessionkey method : member service");
	
		Member member = memberDao.findByMsessionKeyAndMsessionLimitGreaterThan(value, new Date());
		return new Login(member);
	}
	
	@Override
	public void updateImage(String savedDir, int mno) throws Exception {
		logger.info("execute update member image : member service");
	
		memberDao.updateImage(savedDir, mno);
	}

	@Override
	public void updateProfile(Member member, String mpwdConfirm, HttpSession session) throws Exception {
		logger.info("execute member update profile service");
		
		Login loginMember = (Login)session.getAttribute("loginMember");
		Member transac = memberDao.findByMid(loginMember.getMid());
		
		String memail = member.getMemail();
		String mpwd = member.getMpwd();
		String encodedPass = transac.getMpwd();
		
		if(mpwd.isEmpty() || !mpwd.equals(mpwdConfirm) ||
				!BCryptEncoder.matches(mpwd, encodedPass)) {
			throw new Exception("ERR_PASS");
		} else if(!memail.matches(EMAIL_REGEX)) {
			throw new Exception("ERR_EMAIL");
		} else {
			transac.setMemail(memail);
			loginMember.setMemail(memail);
			session.setAttribute("loginMember", loginMember);
		}
	}
	
	@Override
	public void updatePwd(String curPwd, String newPwd, String cPwd, HttpSession session) throws Exception {
		logger.info("execute member update password service");
		
		Login loginMember = (Login)session.getAttribute("loginMember");
		Member transac = memberDao.findByMid(loginMember.getMid());
		String encodedPass = transac.getMpwd();
		
		if(newPwd.isEmpty() || !newPwd.equals(cPwd) ||
				!BCryptEncoder.matches(curPwd, encodedPass)) {
			throw new Exception("ERR_PASS");
		} else {
			transac.setMpwd(BCryptEncoder.encode(newPwd));
		}
	}
	
	@Override
	public void delete(String mpwd, String mpwdConfirm, HttpSession session) throws Exception {
		logger.info("execute member delete service");
		
		Login loginMember = (Login)session.getAttribute("loginMember");
		String encodedPass = memberDao.findByMid(loginMember.getMid()).getMpwd();
		
		if(mpwd.isEmpty() || !mpwd.equals(mpwdConfirm) ||
				!BCryptEncoder.matches(mpwd, encodedPass)) {
			throw new Exception("ERR_PASS");
		} else {
			memberDao.delete(loginMember.getMno());
		}
	}
}
