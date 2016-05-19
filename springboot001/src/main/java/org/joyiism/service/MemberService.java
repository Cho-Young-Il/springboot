package org.joyiism.service;

import java.util.Date;

import org.joyiism.domain.Member;
import org.joyiism.dto.Login;

public interface MemberService {
	public void add(Member member) throws Exception;
	public Member exist(Login login) throws Exception;
	public void keepLogin(String msessionKey, Date next, String mid) throws Exception;
	public Member checkLoginBefore(String value) throws Exception;
}
