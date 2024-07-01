package com.Board.project.service;

import com.Board.project.dto.ArticleForm;
import com.Board.project.entity.Article;
import com.Board.project.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();

        // id 존재시 null 반환 -> 400에러
        if (article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        // Dto -> Entity
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        // 조회
        Article target = articleRepository.findById(id).orElse(null);

        // 잘못된 요청 처리
        if (target == null || id != article.getId()) {
            log.info("잘못된 요청 id: {}, article: {}", id, article.toString());
            return null;
        }

        // 업데이트, 200 응답
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id) {
        // 찾기
        Article target = articleRepository.findById(id).orElse(null);

        // 잘못된 요청 처리
        if (target == null) {
            return null;
        }

        // 대상 삭제
        articleRepository.delete(target);
        return target;
    }

    /* 트랜잭션
//    @Transactional
//    public List<Article> createArticles(List<ArticleForm> dtos) {
//        // dto 묶음 -> entity 묶음 변환
//        List<Article> articleList = new ArrayList<>();
//        for (int i = 0; i < dtos.size(); i++) {
//            ArticleForm dto = dtos.get(i);
//            Article entity = dto.toEntity();
//            articleList.add(entity);
//        }
//        // entity 묶음 -> DB 저장
//        for (int i = 0; i < articleList.size(); i++) {
//            Article article = articleList.get(i);
//            articleRepository.save(article);
//        }
//        // 강제 예외(id가 -1)
//        articleRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("실패"));
//
//        // 결과 값 반환
//        return articleList;
    } */
}
