package com.example.board_practice.web.service;

import com.example.board_practice.web.domain.Post;
import com.example.board_practice.web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post addPost(Post post){
        post.setDate(date());
        postRepository.save(post);
        return  post;
    }

    public Post mathPost(Long postId){
        return postRepository.findById(postId);
    }

    public List<Post> allPostList(){
        return postRepository.findByALl();
    }

    public void updatePost(Long postId){
        postRepository.Update(postId);
    }

    public void deletePost(Long postId){
        postRepository.delete(postId);
    }

    public LocalDate date(){
        LocalDate date = LocalDate.now();
        return date;
    }

}
