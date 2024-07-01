package com.Board.project.service;

import com.Board.project.dto.ArticleForm;
import com.Board.project.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;
    @Test
    void index() {
        //예상
        Article a = new Article(1L, "1번", "1111");
        Article b = new Article(2L, "2번", "2222");
        Article c = new Article(3L, "3번", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c)); //a, b, c 합치기
        //실제
        List<Article> articles = articleService.index();
        //비교 검증
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_sucess() {
        //예상
        Long id = 1L;
        Article expected = new Article(id, "1번", "1111");
        //실제
        Article article = articleService.show(id);
        //비교 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_fail() {
        //예상
        Long id = -1L; //존재하지 않는 -1에 저장
        Article expected = null; //존재하지 않기 때문에 null을 반환할 것으로 예상함
        //실제
        Article article = articleService.show(id);
        //비교 검증
        assertEquals(expected, article);
    }

    @Test
    void create_sucess() {
        //예상
        Long id = 4L;
        String title = "4번";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content); //id는 DB에서 자동 생성
        Article expected = new Article(id, title, content);
        //실제
        Article article = articleService.create(dto);
        //비교 검증
        assertEquals(expected.toString(), article.toString());
    }


    @Test
    void create_fail() {
        //예상
        Long id = 4L;
        String title = "4번";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content); //필요없는 id 입력
        Article expected = null; //id 넣으면 null 반환 예상
        //실제
        Article article = articleService.create(dto);
        //비교 검증
        assertEquals(expected, article);
    }
}