package com.comment.firstproject.service;

import com.comment.firstproject.dto.CommentDto;
import com.comment.firstproject.entity.Article;
import com.comment.firstproject.entity.Comment;
import com.comment.firstproject.repository.ArticleRepository;
import com.comment.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
        // 1. 댓글 조회
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(CommentDto::createCommentDto)
                .collect(Collectors.toList());
        // 2, 엔티티 ->dto로 변환

        // 3. 결과 반환
    }
    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        //1. 게시글 조회 및 예외 처리
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패, 댓글 대상 게시글이 없습니다"));
        //2. 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto, article);
        //3. 댓글 앤티티를 db에 저장
        Comment savedComment = commentRepository.save(comment);
        //4. 엔티티 ->dto 반환후 리턴
        return CommentDto.createCommentDto(savedComment);

    }
}
