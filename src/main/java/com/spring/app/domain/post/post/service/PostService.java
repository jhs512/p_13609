package com.spring.app.domain.post.post.service;

import com.spring.app.domain.post.post.entity.Post;
import com.spring.app.global.rsData.RsData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private long postsLastId = 0;
    private List<Post> posts = new ArrayList<>();

    public List<Post> findAll() {
        return posts.reversed();
    }

    public Optional<Post> findById(long id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst();
    }

    public RsData<Post> write(String title, String body) {
        Post newPost = Post
                .builder()
                .id(++postsLastId)
                .title(title)
                .body(body)
                .build();

        posts.add(newPost);

        return RsData.of(newPost);
    }
}