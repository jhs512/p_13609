package com.spring.app.global.initData;

import com.spring.app.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitData {
    private final PostService postService;

    @Bean
    public ApplicationRunner initData() {
        return args -> {
            postService.write("제목 1", "내용 1");
            postService.write("제목 2", "내용 2");
        };
    }
}

