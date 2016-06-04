package org.joyiism.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("BoardController")
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(HttpSession session, Model model) {
		logger.info("execute board list controller");
		model.addAttribute("loginMember", session.getAttribute("loginMember"));
	}
}
