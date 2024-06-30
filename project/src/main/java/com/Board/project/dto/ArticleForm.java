package com.Board.project.dto;

import com.Board.project.entity.Article;

public class ArticleForm {
    private String title; //제목
    private String content; //내용

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() { //데이터 확인용 toString()
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null, title, content);
    }
}