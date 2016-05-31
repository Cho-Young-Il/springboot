package org.joyiism.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.joyiism.domain.Member;
import org.joyiism.dto.Login;

public interface MemberService {
	void add(Member member, String mpwdConfirm) throws Exception;
	Login exist(Login login) throws Exception;
	void keepLogin(String msessionKey, Date next, String mid) throws Exception;
	Login checkLoginBefore(String value) throws Exception;
	void updateImage(String savedDir, int mno) throws Exception;
	void updateProfile(Member member, String mpwdConfirm, HttpSession session) throws Exception;
	void updatePwd(String curPwd, String newPwd, String cPwd, HttpSession session) throws Exception;
}
