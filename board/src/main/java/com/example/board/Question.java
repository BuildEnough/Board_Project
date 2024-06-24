package com.example.board;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
//@Setter // 엔티티 만들때 Setter 사용안해도됨, 데이터를 자유롭게 변경할 수도 있기 때문
@Entity // 엔티티 클래스로 인식
public class Question {
	@Id // 기본키로 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가
	private Integer id; // 질문 데이터의 고유 번호
	
	@Column(length = 200) // @Column: 테이블의 열 이름과 일치, 길이 200
	private String subject; // 질문 데이터의 제목
	
	@Column(columnDefinition = "TEXT") // 텍스트를 열 데이터로 넣고, 글자 수 제한할 수 없는 경우
	private String content; // 질문 데이터의 내용
	
	private LocalDateTime createDate; // 질문 데이터를 작성한 일시, 카멜케이스라 create_date로 변경됨(열 이름)
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // mappedBy: 참조 엔티티의 속성명을 정의(Question의 참조 속성인 question)
	private List<Answer> anserList; // 질문에서 답변 참조
}
