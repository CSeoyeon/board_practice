package com.example.board_practice.web.repository;

import com.example.board_practice.web.domain.Post;
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
    public Post save(Post post) {
        post.setId(sequence.incrementAndGet());
        store.put(post.getId(), post);
        return post;
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Long postId, Post updatedPost) {
        Post findPost = findById(postId);
        findPost.setPostTitle(updatedPost.getPostTitle());
        findPost.setPostContent(updatedPost.getPostContent());
    }

    @Override
    public Post findById(Long postId) {
        return store.get(postId);
    }

    @Override
    public void delete(Long postId) {
        store.remove(postId);
    }


    //TestCode 목적
    public void clearStore(){
        store.clear();
    }

}
