package com.example.boardservice.web.repository;


import com.example.boardservice.web.domain.Post;

import java.util.List;

public interface PostRepository {
    public Status save(Post post);
    public List<Post> findAll();
    public Status update();


}
