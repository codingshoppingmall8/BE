package com.example.shopping_mall.controller;


import com.example.shopping_mall.request.RequestPostDto;
import com.example.shopping_mall.response.ResponseDto;
import com.example.shopping_mall.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/post")//전체페이지를 리턴
    public ResponseDto<?> getPost(@RequestParam(name = "page")int page){
        return postService.getAllPost(page);
    }
    @GetMapping("sort_post")
    public ResponseDto<?> allPostSort(@RequestParam(name = "page")int page,@RequestParam(name = "sort_method")int method){
        return postService.allPostSort(page,method);
    }
    @GetMapping("/post_category")//전체페이지를 리턴
    public ResponseDto<?> getCategoryPost(@RequestParam(name = "page")int page,@RequestParam(name = "cate_no")int cate_no){
        return postService.getPostByCategory(page,cate_no);
    }
    @GetMapping("/sort_category")//전체페이지를 리턴
    public ResponseDto<?> getCategoryPostSort(@RequestParam(name = "page")int page,@RequestParam(name = "cate_no")int cate_no,@RequestParam(name = "sort_method")int method){
        return postService.sortPostsByCategory(page,cate_no,method);
    }



    @PostMapping("/member/post")
    public ResponseDto<?> createPost(@RequestBody RequestPostDto requestPostDto){
        return postService.createPost(requestPostDto);
    }
    @DeleteMapping("/member/post/{id}")
    public ResponseDto<?> deletePost(@PathVariable("id") Long id){
        return postService.deletePost(id);
    }

    @GetMapping("/post/{id}")
    public ResponseDto<?> getPost(@PathVariable("id") Long id){
        return postService.getPost(id);
    }




}
