package com.sparta.myspring1.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter // 각 멤버변수의 getter를 자동으로 생성해준다.
@MappedSuperclass // 상속했을 때, 이 클래스의 멤버변수를 컬럼으로 인식하게 된다.
// ↓ Audit은 감시하다, 감사하다라는 뜻이며 spring data JPA에서 생성,수정 시간을 자동으로 반영하도록 해준다.
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {

    @CreatedDate // 생성되어 저장될 때 생성일자임를 자동 저장하도록 한다.
    private LocalDateTime createdAt;

    // 이 프로젝트에서는 필요하지 않은 부분이다.
    @LastModifiedDate // 값이 변경됐을 때 그 마지막 수정일자를 자동 저장하도록 한다.
    private LocalDateTime modifiedAt;
}
