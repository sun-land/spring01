package com.sparta.myspring1.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository를 상속하는 PostRepository 생성
// JpaRepository는 spring data JPA에서 제공하는 인터페이스로 미리 검색 메소드를 정의해놓은 인터페이스이다.
// Post라는 Entity에 사용할 PostRepository를 만드려면 JpaRepository< Entity 클래스 이름 , id타입 >를 상속해오면 된다.
// 기본자료형인 경우 Wrapper 클래스를 사용해야 한다. 그래서 아이디를 만들 때 long타입이 아닌 Long 타입으로 설정해줘야 한다.
// JpaRepository<Post, Long>라고 쓰면 데이터를 조회해서 돌려줄 때 Post 타입으로 돌려준다.
public interface PostRepository extends JpaRepository<Post, Long> {

    // save, findall, findby~~, delete 등의 기본 기능을 제외한 조회작업이 하고 싶으면 규칙에 맞는 메소드를 추가할 수 있다.

    // findAllBy : 다 찾아라, OrderBy CreatedAt : CreatedAt 데이터를 기준으로 정렬해라, Desc : 내림차순으로
    // 모든 데이터를 조회하고, CreatedAt 기준으로 내림차순정렬해서 List<Post>형태로 반환해주는 메소드 생성
    List<Post> findAllByOrderByCreatedAtDesc();
}
