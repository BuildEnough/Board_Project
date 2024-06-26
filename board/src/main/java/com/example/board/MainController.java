package com.example.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@GetMapping("/board")
	@ResponseBody
	public String index() {
		return "index 홈페이지에 오신 것을 환영합니다";
	}
	
	@GetMapping("/") // root URL 설정
	public String root() {
		return "redirect:/question/list";
	}
}
