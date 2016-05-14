package org.joyiism.controller;

import org.joyiism.domain.Member;
import org.joyiism.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("MemberController")
public class MemberController {
	@Autowired private MemberService memberService;
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberController.class);
	
	@ResponseBody
	@RequestMapping(value="/member/add", method=RequestMethod.POST)
	public void regist(Member member) {
		logger.info("execute member add controller");
		memberService.add(member);
	}
}
