package com.example.board_practice.web.repository;

import com.example.board_practice.web.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository {

    private static final ConcurrentHashMap<Long, Post> store = new ConcurrentHashMap<>();
    private static final AtomicLong sequence = new AtomicLong();

    public Post save(Post post){
        post.setId(sequence.incrementAndGet());
        store.put(post.getId(), post);
        return post;
    }

    public List<Post> findByALl(){
        return new ArrayList<>(store.values());
    }

    public Post findById(Long postId){
        return store.get(postId);
    }

    public void Update(Long postId){
        Post post = store.get(postId);
        post.setPostTitle(post.getPostTitle());
        post.setPostContent(post.getPostContent());
    }

    public void delete(Long postId){
        store.remove(postId);
    }


}
