package org.joyiism.service.impl;

import org.joyiism.controller.MemberController;
import org.joyiism.dao.MemberDao;
import org.joyiism.domain.Member;
import org.joyiism.service.MemberService;
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
	public void add(Member member) {
		logger.info("execute member insert");
		memberDao.save(member);
	}
}
