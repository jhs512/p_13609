package com.spring.app.domain.post.post.controller;

import com.spring.app.global.rsData.RsData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
public class ApiV1PostController {
    @GetMapping("/{id}")
    public RsData getItem(
            @PathVariable long id
    ) {
        LocalDateTime createDate = LocalDateTime.now();
        LocalDateTime modifyDate = LocalDateTime.now();
        String title = "제목 " + id;
        String body = "내용 " + id;

        return new RsData(
                "S-200",
                "성공",
                Map.of(
                        "id", id,
                        "createDate", createDate,
                        "modifyDate", modifyDate,
                        "title", title,
                        "body", body
                )
        );
    }
}
