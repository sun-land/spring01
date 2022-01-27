package com.sparta.myspring1.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 각 멤버변수의 getter를 자동으로 생성해준다.
@NoArgsConstructor // 기본 생성자를 자동으로 생성해준다. JPA를 사용하는 Entity는 꼭 기본생성자를 가지고 있어야 한다.
@Entity  // 이 클래스가 테이블임을 나타낸다.
public class Post extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령
    @Id // Id값, 즉 Primary key로 사용하겠다는 뜻이다.
    private Long id;

    @Column(nullable = false) // 이 멤버변수가 Column 값이고 반드시 존재해야함을 나타낸다.
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    // DTO를 변수로 받아서 Post를 생성하는 생성자
    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}
