package com.example.board_practice.web.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Board {

    private Long id;
    private String title;
    private String content;
    private LocalDate date;

    public Board(String title, String content, LocalDate date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Board(){}

}
