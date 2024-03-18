package com.comment.firstproject.entity;


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
}
