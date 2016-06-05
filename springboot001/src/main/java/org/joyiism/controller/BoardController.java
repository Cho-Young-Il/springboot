package org.joyiism.controller;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller("BoardController")
@RequestMapping("/board/*")
public class BoardController {
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(HttpSession session, Model model) {
		logger.info("execute board list controller");
		model.addAttribute("loginMember", session.getAttribute("loginMember"));
	}
	
	@ResponseBody
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public String add(MultipartHttpServletRequest mRequest) {
		logger.info("execute board regist controller");
		
		String btitle = mRequest.getParameter("btitle");
		String bcontent = mRequest.getParameter("bcontent");
		int mno = Integer.parseInt(mRequest.getParameter("mno"));
		
		logger.info("btitle : " + btitle);
		logger.info("bcontent : " + bcontent);
		logger.info("mno : " + mno);
		
		//List<MultipartFile> files = mRequest.getParameter("attachFiles");
		
		
		Iterator<String> iterator = mRequest.getFileNames();
		int size = 0;
		while(iterator.hasNext()) {
			String fileName = iterator.next();
			logger.info("fileName : " + fileName);
			size++;
			logger.info("1");
		}
		logger.info("fileCnt : " + size);
		
		return null;
	}
}
