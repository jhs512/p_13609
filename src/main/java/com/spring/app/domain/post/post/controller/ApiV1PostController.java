package com.spring.app.domain.post.post.controller;

import com.spring.app.domain.post.post.entity.Post;
import com.spring.app.global.rsData.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class ApiV1PostController {
    @AllArgsConstructor
    @Getter
    public static class PostGetItemResBody {
        private Post item;
    }

    @GetMapping("/{id}")
    public RsData<PostGetItemResBody> getItem(
            @PathVariable long id
    ) {
        Post post = Post.builder()
                .id(id)
                .title("제목 " + id)
                .body("내용 " + id)
                .build();

        return RsData.of(new PostGetItemResBody(post));
    }
}
