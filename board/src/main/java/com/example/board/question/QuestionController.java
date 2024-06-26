package com.example.board.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question") // URL 프리픽스
@RequiredArgsConstructor // final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 줌
@Controller
public class QuestionController {
	
	private final QuestionService questionService; // 서비스 사용
	
	@GetMapping("/list")
	public String list(Model model) { // Model: 자바 클래스와 템플릿 간의 연결고리
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
	@GetMapping(value = "/detail/{id}") // 상세페이지
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
}
