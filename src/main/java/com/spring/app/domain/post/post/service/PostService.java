package com.spring.app.domain.post.post.service;

import com.spring.app.domain.post.post.entity.Post;
import com.spring.app.domain.post.post.repository.PostRepository;
import com.spring.app.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }

    public RsData<Post> write(String title, String body) {
        Post newPost = Post
                .builder()
                .title(title)
                .body(body)
                .build();

        postRepository.save(newPost);

        return RsData.of(newPost);
    }
}