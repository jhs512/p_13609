package com.spring.app.domain.post.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class ApiV1PostController {
    @GetMapping("/{id}")
    public String getItem(
            @PathVariable long id
    ) {
        return "%d번 글 조회".formatted(id);
    }
}
