package com.Board.project.service;

import com.Board.project.dto.CommentDto;
import com.Board.project.entity.Article;
import com.Board.project.entity.Comment;
import com.Board.project.repository.ArticleRepository;
import com.Board.project.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List comments(Long articleId) {
        //조회
        List<Comment> comments = commentRepository.findByArticledId(articleId);
        //entity->dto
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for (int i = 0; i < comments.size(); i++) {
            Comment c = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);
        }
        //결과
        return dtos;
    }

    @Transactional // DB 실패할 경우 대비
    public CommentDto create(Long articleId, CommentDto dto) {
        //게시글 조회, 예외 발생
        Article article = articleRepository.findById(articleId) //부모 게시글 가져옴
                .orElseThrow(()-> new IllegalArgumentException("댓글 생성 실패"));
        //댓글 entity
        Comment comment = Comment.createComment(dto, article);
        //댓글 entity->DB
        Comment created = commentRepository.save(comment);
        //DTO변환
        return CommentDto.createCommentDto(created);
    }
}
