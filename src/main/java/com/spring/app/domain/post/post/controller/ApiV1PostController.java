package com.spring.app.domain.post.post.controller;

import com.spring.app.domain.post.post.entity.Post;
import com.spring.app.global.rsData.RsData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class ApiV1PostController {
    public record PostGetItemResBody(Post item) {
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


    public record PostWriteItemResBody(Post item) {
    }

    @PostMapping("")
    public RsData<PostWriteItemResBody> write() {
        long id = 1000;

        Post post = Post.builder()
                .id(id)
                .title("제목 " + id)
                .body("내용 " + id)
                .build();

        return RsData.of(new PostWriteItemResBody(post));
    }
}
