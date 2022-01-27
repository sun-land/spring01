package com.sparta.myspring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableJpaAuditing // JPA의 Auditing 기능을 활성화해준다.
@SpringBootApplication
public class Myspring1Application {

    //서버의 Timezone 안바꾸고 한국시간으로 설정하는 방법
    //@PostConstruct
    //public void started() {
        //timezone 셋팅
        //TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul")); }

    public static void main(String[] args) {
        SpringApplication.run(Myspring1Application.class, args);
    }

}

