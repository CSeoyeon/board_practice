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
@RequestMapping("/")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping //start page
    public String postList(Model model ){
        List<Post> posts = postService.postFindALl();
        model.addAttribute("posts", posts);
        return "board/postList";
    }

    @GetMapping("{postId}")
    public String Post(@PathVariable Long postId, Model model){
        Post post = postService.postMatch(postId);
        model.addAttribute("post", post);
        return "board/post";
    }

    @GetMapping("addPost")
    public String addPostForm(){
        return "board/addPost";
    }

    @PostMapping("postList/addPost")
    public String addPost(@ModelAttribute Post post, RedirectAttributes redirectAttributes){
        postService.addPost(post);
        redirectAttributes.addAttribute("postId", post.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/{postId}";
    }


    @GetMapping("{postId}/edit")
    public String editForm(@PathVariable Long postId, Model model){
        Post post = postService.postMatch(postId);
        model.addAttribute("post", post);
        return "board/editPost";
    }

    @PostMapping("{postId}/edit")
    public String editPost(@PathVariable Long postId, @ModelAttribute Post post){
        postService.postUpdate(postId, post);
        return "redirect:/{postId}";
    }



}
