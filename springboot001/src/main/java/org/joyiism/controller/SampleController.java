package org.joyiism.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("msg", "Hello");
		return "hello";
	}
}
