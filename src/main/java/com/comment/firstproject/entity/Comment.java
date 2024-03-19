package com.comment.firstproject.entity;


import com.comment.firstproject.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 대표키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id") // 외래키 생성, article 엔티티의 기본키와 매핑
    private Article article;

    @Column
    private String nickname;
    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) {
        //예외 발생
        if (dto.getId() != null)
            throw new IllegalArgumentException("댓글에 id가 없어야 됩니다");
        if (dto.getArticleId() != article.getId())
            throw new IllegalArgumentException("게시글의 id가 잘못되었씁니다.");

        // 엔티티 생성 및 반환
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }
}
