package org.joyiism.service;

import java.util.Date;

import org.joyiism.domain.Member;
import org.joyiism.dto.Login;

public interface MemberService {
	void add(Member member) throws Exception;
	Member exist(Login login) throws Exception;
	void keepLogin(String msessionKey, Date next, String mid) throws Exception;
	Member checkLoginBefore(String value) throws Exception;
}
