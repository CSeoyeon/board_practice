package com.example.boardservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/postList")
@RequiredArgsConstructor
public class PostController {

    @GetMapping
    public String home(){
        return "/postList";
    }

}
