package com.Board.project.entity;

import com.Board.project.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    @Column
    private String nickname;
    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) {
        //예외
        if (dto.getId() != null) {
            throw new IllegalArgumentException("댓글 생성실패, id 존재함");
        }
        if (dto.getArticleId() != article.getId()){
            throw new IllegalArgumentException("댓글 생성실패, id가 잘못됨");
        }
        //entity생성, 반환
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDto dto) {
        //예외
        if (this.id != dto.getId()) {
            throw new IllegalArgumentException("댓글 수정 실패, 잘못된 id가 입력");
        }
        //객체 갱신
        if (dto.getNickname() != null) {
            this.nickname = dto.getNickname();
        }
        if (dto.getBody() != null) {
            this.body = dto.getBody();
        }
    }
}
