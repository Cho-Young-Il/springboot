package org.joyiism.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.joyiism.domain.Member;
import org.joyiism.dto.MemberDTO;

public interface MemberService {
	void add(Member member, String mpwdConfirm) throws Exception;
	MemberDTO exist(MemberDTO login) throws Exception;
	void keepLogin(String msessionKey, Date next, String mid) throws Exception;
	MemberDTO checkLoginBefore(String value) throws Exception;
	void updateImage(String savedDir, int mno) throws Exception;
	void updateProfile(Member member, String mpwdConfirm, HttpSession session) throws Exception;
	void updatePwd(String curPwd, String newPwd, String cPwd, HttpSession session) throws Exception;
	void delete(String mpwd, String mpwdConfirm, HttpSession session) throws Exception;
	MemberDTO getLoginMember(HttpSession session) throws Exception;
}
