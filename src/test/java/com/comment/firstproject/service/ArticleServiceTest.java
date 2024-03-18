package com.comment.firstproject.service;

import com.comment.firstproject.entity.Article;
import org.junit.jupiter.api.AfterEach;
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

    @AfterEach

    @Test
    void index() {
        //given
        Article a = new Article(1L, "a", "aa");
        Article b = new Article(2L, "b", "bb");
        Article c = new Article(3L, "c", "cc");
        ArrayList<Article> expected = new ArrayList<>(Arrays.asList(a, b, c));
        //when
        List<Article> articles = articleService.index();
        //then
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공() {
        //given
        Article expected = new Article(1L, "a", "aa");
        //when
        Article article = articleService.show(expected.getId());
        //then
        assertEquals(expected.toString(),article.toString());

    }
    @Test
    void shwo_실패() {
        //given
        Article expected = new Article(2L, "a", "aa");
        //when
        Article article = articleService.show(expected.getId());
        //then
        assertNotEquals(expected.toString(),article.toString());
    }
}