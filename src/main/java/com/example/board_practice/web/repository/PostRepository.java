package com.example.board_practice.web.repository;


import com.example.board_practice.web.domain.Post;

import java.util.List;

public interface PostRepository {
    public Post save(Post post);
    public List<Post> findAll();
    public Post update();


}
