package org.joyiism.controller;

import javax.servlet.http.HttpSession;

import org.joyiism.domain.Board;
import org.joyiism.service.AttachfileService;
import org.joyiism.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller("BoardController")
@RequestMapping("/board/*")
public class BoardController {
	@Autowired private BoardService boardService;
	@Autowired private AttachfileService attachfileService;
	private final String STATIC_ROOT = "src/main/resources/static";
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(HttpSession session, Model model) {
		logger.info("execute board list controller");
		model.addAttribute("loginMember", session.getAttribute("loginMember"));
	}
	
	@ResponseBody @Transactional
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public String add(MultipartHttpServletRequest mRequest) {
		logger.info("execute board regist controller");
		
		String errMsg = null;
		try {
			Board board = boardService.regist(mRequest);
			attachfileService.regist(STATIC_ROOT + "/attachfile", board, mRequest);
		} catch (Exception e) {
			logger.error("error board regist", e);
			errMsg = e.getMessage();
		}
		return errMsg;
	}
}
