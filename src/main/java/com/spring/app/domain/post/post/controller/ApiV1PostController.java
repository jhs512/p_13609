package com.spring.app.domain.post.post.controller;

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
        long id = ++postsLastId;

        Post post = Post.builder()
                .id(id)
                .title("제목 " + id)
                .body("내용 " + id)
                .build();

        posts.add(post);

        return RsData.of(
                "S-200",
                "%d번 글이 생성되었습니다.".formatted(id),
                new PostWriteItemResBody(post)
        );
    }
}
