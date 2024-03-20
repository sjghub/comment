package com.comment.firstproject.dto;

import com.comment.firstproject.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class CommentDto {
    private Long id;
//    @JsonProperty("article_id") 이 어노테이션 떄문에 웹페이지에서 event를 통해 댓글 생성이 안됬음
    private Long articleId;
    private String nickname;
    private String body;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getArticle().getId(),
                comment.getNickname(),
                comment.getBody()
    );
    }
}
