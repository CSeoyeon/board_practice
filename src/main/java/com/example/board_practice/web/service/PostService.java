package com.example.board_practice.web.service;


import com.example.board_practice.web.domain.Post;
import com.example.board_practice.web.repository.PostRepository;
import com.example.board_practice.web.repository.PostRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository = new PostRepositoryImpl();
    public List<Post> postFindALl(){
        return postRepository.findAll();
    }

    public void addPost(Post post){
        postRepository.save(post);
    }

    public Post postMatch(Long postId){
        return postRepository.findById(postId);
    }

    public void postUpdate(Long postId, Post updatedPost){
        postRepository.update(postId, updatedPost);
    }

}
