package com.example.board_practice.web.controller;


import com.example.board_practice.web.domain.Post;
import com.example.board_practice.web.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public String postList(Model model){
        List<Post> posts = postService.allPostList();
        model.addAttribute("posts", posts);
        return "board/postList";
    }

    @GetMapping("/addPost")
    public String addPostForm(){
        return "board/addPost";
    }

    @GetMapping("/{postId}")
    public String post(@PathVariable Long postId, Model model){
        Post post = postService.mathPost(postId);
        model.addAttribute("post", post);
        return "board/post";
    }

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute Post post, RedirectAttributes redirectAttributes){
        postService.addPost(post);
        redirectAttributes.addAttribute("postId", post.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/{postId}";
    }

    @GetMapping("/{postId}/edit")
    public String editPostForm(@PathVariable Long postId, Model model){
        Post post = postService.mathPost(postId);
        model.addAttribute(post);
        return "board/editPost";
    }

    @PostMapping("/{postId}/edit")
    public String editPost(@PathVariable Long postId, RedirectAttributes redirectAttributes){
        postService.updatePost(postId);
        redirectAttributes.addAttribute("postId", postId);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/{postId}";
    }


    @GetMapping("/{postId}/delete")
    public String deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
        return "board/postList";
    }



}
