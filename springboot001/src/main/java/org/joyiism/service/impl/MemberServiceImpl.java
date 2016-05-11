package org.joyiism.service.impl;

import org.joyiism.dao.MemberDao;
import org.joyiism.domain.Member;
import org.joyiism.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDao memberDao;
	
	@Override
	public void add(Member member) {
		memberDao.save(member);
	}
}
