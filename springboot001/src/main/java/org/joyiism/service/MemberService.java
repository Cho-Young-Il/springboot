package org.joyiism.service;

import java.util.Date;

import org.joyiism.domain.Member;
import org.joyiism.dto.Login;

public interface MemberService {
	void add(Member member) throws Exception;
	Login exist(Login login) throws Exception;
	void keepLogin(String msessionKey, Date next, String mid) throws Exception;
	Login checkLoginBefore(String value) throws Exception;
	void updateImage(String savedDir, int mno) throws Exception;
}
