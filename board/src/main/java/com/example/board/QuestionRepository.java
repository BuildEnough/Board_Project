package com.example.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> { // Question 엔티티의 기본키가 Integer
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);
}
