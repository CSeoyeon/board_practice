package com.example.board_practice.web.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Data
public class Post {

    private Long id;
    private String postTitle;
    private String postContent;
    private LocalDate date;

    public Post(String postName, String postContent, LocalDate date) {
        this.postTitle = postName;
        this.postContent = postContent;
        this.date = date;
    }

    public Post(){}
}
