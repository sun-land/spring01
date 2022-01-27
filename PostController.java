package com.sparta.myspring1.controller;

import com.sparta.myspring1.domain.Post;
import com.sparta.myspring1.domain.PostRepository;
import com.sparta.myspring1.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // 필요한 생성자를 자동으로 생성해준다.
@RestController
public class PostController {
    private final PostRepository postRepository;

    // 게시글 등록하기 API
    @PostMapping("/api/posts")
    // @RequestBody는 사용자가 바디에 입력한 값을 받아오도록 해주는 어노테이션이다.
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        // 받은 정보로 Post 타입의 인스턴스 생성
        Post post = new Post(requestDto);
        // 데이터 저장
        return postRepository.save(post);
    }

    // 게시글 모두 보여주기 API
    @GetMapping("/api/posts")
    public List<Post> showPost() {
        // 모든 데이터 반환 + PostRepository에서 설정한 메소드로 생성일 기준 내림차순으로 정렬해서 반환된다.
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    // 선택한 게시글 하나 보여주기 API
    @GetMapping("/api/posts/{id}")
    // PathVariable은 주소로 넘어온 값을 받을 수 있게 해주는 어노테이션이다.
    public Post showOnePost(@PathVariable Long id) {
        // id로 데이터 조회해서 Post 타입으로 받아오기
        // findAll이 아닌 findById를 써서 id로 조회할 떄는 일치하는 id가 없을 때 어떻게 할 것인지 결정해줘야한다.
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("찾는 게시글이 없습니다.")
        );
        // 찾은 데이터 반환
        return post;
    }

    // 선택한 게시글 지우기 API
    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        // 데이터 삭제
        postRepository.deleteById(id);
        // 삭제한 데이터의 아이디값 반환
        return id;
    }

}
