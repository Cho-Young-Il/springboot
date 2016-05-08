package org.joyiism.controller;

import org.joyiism.domain.FreemarkerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("FreemarkerTestController")
public class FreemarkerTestController {
	@Autowired private FreemarkerTest FreemarkerTest;
	@RequestMapping(value = "/test")
	 public ModelAndView getBlog(ModelAndView mv) {
	    mv.addObject("Title", "Freemarker Template Demo using Spring");
	    mv.addObject("message", "Getting started with Freemarker.<br/>Find a Freemarker template demo using Spring.");
	    mv.addObject("references", FreemarkerTest.getFreemarkerTestList());
	    mv.setViewName("test-template");
	    return mv;
	}
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String viewMain() {
		return "test/main";
	}
}
