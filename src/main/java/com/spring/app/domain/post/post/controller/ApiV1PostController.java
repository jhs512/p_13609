package com.spring.app.domain.post.post.controller;

import com.spring.app.domain.post.post.dto.PostDto;
import com.spring.app.domain.post.post.entity.Post;
import com.spring.app.domain.post.post.service.PostService;
import com.spring.app.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class ApiV1PostController {
    private final PostService postService;


    public record PostGetItemsResBody(List<PostDto> items) {
    }

    @GetMapping("")
    public RsData<PostGetItemsResBody> getItems() {
        List<Post> posts = postService.findAll();

        return RsData.of(new PostGetItemsResBody(
                posts
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
        Post post = postService.findById(id).get();

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
        Post newPost = postService.write(reqBody.title(), reqBody.content()).getBody();

        return RsData.of(
                "S-200",
                "%d번 글이 생성되었습니다.".formatted(newPost.getId()),
                new PostWriteItemResBody(new PostDto(newPost))
        );
    }
}