package org.joyiism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Springboot001Application {
	public static void main(String[] args) {
		SpringApplication.run(Springboot001Application.class, args);
	}
}

@Controller("HomeController")
class HomeController {
	@RequestMapping(value="/")
	public String index() {
		return "main/main";
	}
}
