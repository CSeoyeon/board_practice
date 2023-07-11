package com.example.board_practice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/postList")
@RequiredArgsConstructor
public class PostController {

    @GetMapping
    public String postList(){
        return "/board/postList";
    }

}
