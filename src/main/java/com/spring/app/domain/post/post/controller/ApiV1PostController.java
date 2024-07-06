package com.spring.app.domain.post.post.controller;

import com.spring.app.domain.post.post.dto.PostDto;
import com.spring.app.domain.post.post.entity.Post;
import com.spring.app.global.rsData.RsData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class ApiV1PostController {
    private long postsLastId = 0;
    private List<Post> posts = new ArrayList<>();


    public record PostGetItemsResBody(List<PostDto> items) {
    }

    @GetMapping("")
    public RsData<PostGetItemsResBody> getItems() {
        return RsData.of(new PostGetItemsResBody(
                posts.reversed()
                        .stream()
                        .map(PostDto::new)
                        .toList()
        ));
    }


    public record PostGetItemResBody(PostDto item) {
    }

    @GetMapping("/{id}")
    public RsData<PostGetItemResBody> getItem(
            @PathVariable long id
    ) {
        Post post = posts
                .stream()
                .filter(it -> it.getId() == id)
                .findFirst()
                .orElseThrow();

        return RsData.of(new PostGetItemResBody(new PostDto(post)));
    }


    public record PostWriteItemReqBody(
            String title,
            String content
    ) {
    }

    public record PostWriteItemResBody(PostDto item) {
    }

    @PostMapping("")
    public RsData<PostWriteItemResBody> write(
            @RequestBody PostWriteItemReqBody reqBody
    ) {
        long id = ++postsLastId;

        Post post = Post.builder()
                .id(id)
                .title(reqBody.title)
                .body(reqBody.content)
                .build();

        posts.add(post);

        return RsData.of(
                "S-200",
                "%d번 글이 생성되었습니다.".formatted(id),
                new PostWriteItemResBody(new PostDto(post))
        );
    }
}