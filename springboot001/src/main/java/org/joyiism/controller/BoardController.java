package org.joyiism.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joyiism.domain.PageMaker;
import org.joyiism.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller("BoardController")
@RequestMapping("/board")
public class BoardController {
	@Autowired private BoardService boardService;
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getSession(HttpSession session) {
		logger.info("execute get session controller");
		return new ModelAndView("board/list")
				.addObject(session.getAttribute("loginMember"));
	}
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public Map<String, Object> list(PageMaker pageMaker) {
		
		return null;
	}
	
	@ResponseBody @Transactional
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String add(MultipartHttpServletRequest mRequest) {
		logger.info("execute board regist controller");
		
		String errMsg = null;
		try {
			boardService.regist(mRequest);
		} catch (Exception e) {
			logger.error("error board regist", e);
			errMsg = e.getMessage();
		}
		return errMsg;
	}
}
