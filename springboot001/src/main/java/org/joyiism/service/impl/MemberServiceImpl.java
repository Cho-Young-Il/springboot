package org.joyiism.service.impl;

import java.util.Date;

import org.joyiism.controller.MemberController;
import org.joyiism.dao.MemberDao;
import org.joyiism.domain.Member;
import org.joyiism.dto.Login;
import org.joyiism.service.MemberService;
import org.joyiism.util.BCryptEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDao memberDao;
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberController.class);
	private static final String NAME_REGEX = "[가-힣]{2,4}|[a-zA-Z]{3,20}";
	private static final String EMAIL_REGEX = "([\\w-]+(?:\\.[\\w-]+)*)@"
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
		if(BCryptEncoder.matches(login.getMpwd(), member.getMpwd()) && member != null) {
			return new Login(member.getMno(), member.getMid(), 
				member.getMemail(), member.getMname(), member.getMphoto());
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
		Member member = memberDao.checkMemberWithSessionKey(value);
		return new Login(member.getMno(), member.getMid(), 
			member.getMemail(), member.getMname(), member.getMphoto());
	}
	
	@Override
	public void updateImage(String savedDir, int mno) throws Exception {
		logger.info("execute update member image : member service");
		memberDao.updateImage(savedDir, mno);
	}
}
