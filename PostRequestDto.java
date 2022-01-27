package com.sparta.myspring1.domain;

import lombok.Getter;

// DTO(Data Transfer Object)는 계층간에 데이터를 실어나르는 역할을 하는 객체다.
// 데이터 데이터베이스에 바로 넣었다 뺐다 하면 데이터베이스에 예기치못한 일이 생길 수 있으므로 중간에 DTO에 실어 나른다.
// 데이터를 담아서 나르기 위한 상자일 뿐이기 때문에 로직은 가지고 있지 않고 순수한 데이터와 Setter, Getter만 가진 객체이다.
@Getter
public class PostRequestDto {
    private String title;
    private String username;
    private String contents;
}
