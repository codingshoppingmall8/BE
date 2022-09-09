package com.example.shopping_mall.controller;


import com.example.shopping_mall.request.RequestPostDto;
import com.example.shopping_mall.response.ResponseDto;
import com.example.shopping_mall.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/member/post")
    public ResponseDto<?> createPost(@RequestBody RequestPostDto requestPostDto){
        return postService.createPost(requestPostDto);

    }
    @DeleteMapping("/member/post/{id}")
    public ResponseDto<?> createPost(@PathVariable("id") Long id){
        return postService.deletePost(id);
    }

    @GetMapping("/member/post/{id}")
    public ResponseDto<?> getPost(@PathVariable("id") Long id){
        return postService.getPost(id);
    }




}
