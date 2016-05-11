package org.joyiism.controller;

import org.joyiism.domain.AjaxResult;
import org.joyiism.domain.Member;
import org.joyiism.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("MemberController")
public class MemberController {
	@Autowired private MemberService memberService;
	@Autowired private AjaxResult ajaxResult;
	
	@ResponseBody
	@RequestMapping(value="/member/add.json", method=RequestMethod.POST)
	public Object regist(Member member) {
		memberService.add(member);
		return ajaxResult.setStatus("success");
	}
}
