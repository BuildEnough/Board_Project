package com.example.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardApplicationTests {
	
	@Autowired // 의존성 주입(DI)
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		Question q = this.questionRepository.findBySubjectAndContent("test1", "test1 test1");
		assertEquals(1, q.getId());
	}

}