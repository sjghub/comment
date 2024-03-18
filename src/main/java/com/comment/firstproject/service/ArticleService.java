package com.comment.firstproject.service;


import com.comment.firstproject.dto.ArticleForm;
import com.comment.firstproject.entity.Article;
import com.comment.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return (List<Article>) articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        if (article.getId() != null) {
            return null;
        } // 이미 존재하는 id로 creat 할 떄 수정되는것을 방지
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        // 1. 찾기
        Article article = dto.toEntity();

        // 2. 조회
        Article target = articleRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리
        if (target == null || id != article.getId()) {
            log.info("잘못된 요청! id : {}, article : {}", id, article.toString());
        }
        // 4. 수정
        target.patch(article);
        Article updated = articleRepository.save(target);

        return updated;
    }

    public Article delete(Long id) {
        // 1. 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리하기
        if (target == null) {
            return null;
        }
        // 3 . 대상 삭제하기
        articleRepository.delete(target);
        return target;
    }

    public List<Article> createArticles(List<Article> dtos) {
        // 1. dtos 를 엔티티 묶음으로 변경
        // 2. 엔티티 묶음을 db에 저장
        // 3. 강제 예외 발생
        // 4. 결과값 반환
    }
}
