package com.spring.app.domain.post.post.repository;

import com.spring.app.domain.post.post.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private long postsLastId = 0;
    private List<Post> posts = new ArrayList<>();

    public List<Post> findAll() {
        return posts.reversed();
    }

    public Optional<Post> findById(long id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst();
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(++postsLastId);
        }

        posts.add(post);
    }
}