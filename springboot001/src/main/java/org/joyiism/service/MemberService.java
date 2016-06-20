package org.joyiism.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.joyiism.domain.Member;
import org.joyiism.dto.LoginDTO;

public interface MemberService {
	void add(Member member, String mpwdConfirm) throws Exception;
	LoginDTO exist(LoginDTO login) throws Exception;
	void keepLogin(String msessionKey, Date next, String mid) throws Exception;
	LoginDTO checkLoginBefore(String value) throws Exception;
	void updateImage(String savedDir, int mno) throws Exception;
	void updateProfile(Member member, String mpwdConfirm, HttpSession session) throws Exception;
	void updatePwd(String curPwd, String newPwd, String cPwd, HttpSession session) throws Exception;
	void delete(String mpwd, String mpwdConfirm, HttpSession session) throws Exception;
	LoginDTO getLoginMember(HttpSession session) throws Exception;
}
