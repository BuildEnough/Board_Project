package com.example.board;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // 답변 데이터의 고유 번호
	
	@Column(columnDefinition = "TEXT")
	private String content; // 답변 데이터의 내용
	
	@CreatedDate
	private LocalDateTime createDate; // 답변 데이터를 작성한 일시 
	
	@ManyToOne // 부모 Question, 자식 Answer
	private Question question; // 질문 데이터
}
