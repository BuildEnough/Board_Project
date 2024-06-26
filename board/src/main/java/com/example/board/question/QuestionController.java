package com.example.board.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 줌
@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	
	@GetMapping("/question/list")
	public String list(Model model) { // Model: 자바 클래스와 템플릿 간의 연결고리
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
}
