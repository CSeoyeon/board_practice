package com.example.boardservice.web.repository;

import com.example.board_practice.web.domain.Post;
import com.example.board_practice.web.repository.PostRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PostRepositoryImplTest {

    PostRepositoryImpl postRepository = new PostRepositoryImpl();


    @AfterEach
    void afterEach(){
        postRepository.clearStore();
    }

    @Test
    void save(){
        //given
        LocalDate date = LocalDate.now();
        Post post = new Post("postName", "1234", date);
        Post post2 = new  Post("postName", "1234", date);

        //when
        postRepository.save(post);
        postRepository.save(post2);

        //then

        //저장확인
        int size = postRepository.findAll().size();
        assertThat(size).isEqualTo(2);

        //AtomicLong 잘 들어갔는지
        Long id = postRepository.findAll().get(1).getId();
        assertThat(id).isEqualTo(2L);


    }



}