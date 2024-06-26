package com.example.board.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.board.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // 서비스 생성
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	public List<Question> getList() {
		return this.questionRepository.findAll();
	}

	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if (question.isPresent()) { // isPresent(): Optional 객체가 값을 가지고 있다면 true, 아니면 false
			return question.get();
		} else {
			throw new DataNotFoundException("question not found");
		}
	}
}
