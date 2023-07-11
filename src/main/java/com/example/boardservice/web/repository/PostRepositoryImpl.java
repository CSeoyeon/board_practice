package com.example.boardservice.web.repository;

import com.example.boardservice.web.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepositoryImpl implements PostRepository{
    private static final ConcurrentHashMap<Long, Post> store = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong();

    @Override
    public Status save(Post post) {
        post.setId(sequence.incrementAndGet());
        store.put(post.getId(), post);
        return Status.COMPLETE;
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Status update() {
        return null;
    }
}
