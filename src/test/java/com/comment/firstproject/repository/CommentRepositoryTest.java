package com.comment.firstproject.repository;

import com.comment.firstproject.entity.Article;
import com.comment.firstproject.entity.Comment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Test
    @DisplayName("특정 게시글의 모든 댓글")
    void findByArticleId() {
        //given
        Long articleId = 4L;

        Article article = new Article(4L, "당신의 인생 영화는?", "영화댓글");
        Comment a = new Comment(1L, article, "park", "굿 윌 헌팅");
        Comment b = new Comment(2L, article, "kim", "아이");
        List<Comment> expected = Arrays.asList(a, b);
        //when
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        //then
        assertEquals(expected.toString(), comments.toString());

    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickName() {
        //park의 모든 댓글 조회

        //given
        String nickname = "park";

        Comment a = new Comment(1L, new Article(4L, "당신의 인생 영화는?", "영화댓글"), nickname, "굿 윌 헌팅");
        Comment b = new Comment(3L, new Article(5L, "당신의 소울 푸드는?", "소울푸드댓글"), nickname,"치킨");
        Comment c = new Comment(6L, new Article(6L, "당신의 취미는?", "취미댓글"), nickname,"축구");

        List<Comment> expected = Arrays.asList(a, b, c);
        //when
        List<Comment> byNickName = commentRepository.findByNickName(nickname);
        //then

        assertEquals(expected.toString(),byNickName.toString());
    }
}