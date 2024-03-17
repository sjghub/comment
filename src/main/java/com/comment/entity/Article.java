package com.comment.entity;

import jakarta.persistence.*;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 ID를 자동생성
    private Long id;

    @Column
    private String title;

    @Column
    private String content;



}
