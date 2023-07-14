package com.example.board_practice.web.domain;


import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Post {

    private Long id;
    private String postTitle;
    private String postContent;
    private LocalDate date;

    public Post(String postTitle, String postContent, LocalDate date) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.date = date;
    }

    public Post(){}


}
