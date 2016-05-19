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
	
	@Override
	public void add(Member member) throws Exception{
		logger.info("execute member insert");
		member.setMphoto("none");
		member.setMsessionKey("none");
		memberDao.save(member);
	}
	
	@Override
	public Member exist(Login login) throws Exception {
		logger.info("check member exist");
		Member member = memberDao.findByMid(login.getMid());
		if(BCryptEncoder.matches(login.getMpwd(), member.getMpwd())
			&& member != null) {
			return member;
		}
		return null;
	}
	
	@Override
	public void keepLogin(String msessionKey, Date next, String mid) throws Exception {
		logger.info("execute keep login method : member service");
		memberDao.keepLogin(msessionKey, next, mid);
	}
	
	@Override
	public Member checkLoginBefore(String value) throws Exception {
		logger.info("execute check member width sessionkey method : member service");
		return memberDao.checkMemberWithSessionKey(value);
	}
}
