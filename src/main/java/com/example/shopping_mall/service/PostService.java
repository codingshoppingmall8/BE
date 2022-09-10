package com.example.shopping_mall.service;

import com.example.shopping_mall.entity.Category;
import com.example.shopping_mall.entity.Post;
import com.example.shopping_mall.repository.PostRepository;
import com.example.shopping_mall.request.RequestPostDto;
import com.example.shopping_mall.response.ResponseDto;
import com.example.shopping_mall.response.ResponsePostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostService {
    private  final PostRepository postRepository;
    @Transactional
    public ResponseDto<?> getAllPost(int page) { //전체 리스트를 return
        Pageable pageable = PageRequest.of(page-1,30,Sort.by("createdAt").descending());//기본값으로 최신순으로 정렬됨
        Page<Post> posts = postRepository.findAll(pageable);
        return ResponseDto.success(posts);
    }
    @Transactional
    public ResponseDto<?> allPostSort(int page,int method) { //전체 리스트 정렬 할때 .
        Pageable pageable;
        if(method ==1){
             pageable = PageRequest.of(page-1,30,Sort.by("cnt"));
        }
        else if(method ==2){
             pageable = PageRequest.of(page-1,30,Sort.by("cost"));
        }
        else if(method ==3){
             pageable = PageRequest.of(page-1,30,Sort.by("cost").descending());
        }
        else
            pageable = PageRequest.of(page-1,30,Sort.by("title"));
        Page<Post> posts = postRepository.findAll(pageable);//전체를 그냥 조회 할 때
        return ResponseDto.success(posts);
    }
    @Transactional
    public ResponseDto<?> getPostByCategory(int page, int cate_num) { //전체 리스트를 return
        Pageable pageable = PageRequest.of(page-1,30,Sort.by("createdAt").descending());//기본값
        Page<Post> posts;
        Category[] categories =Category.values();
        posts = postRepository.findByCategory(pageable,categories[cate_num]);
        return ResponseDto.success(posts);
    }
    @Transactional
    public ResponseDto<?> sortPostsByCategory(int page,int cate_num,int method){
        Pageable pageable;
        if(method == 1){
            pageable = PageRequest.of(page-1,30,Sort.by("cnt"));
        }
        else if(method ==2){
            pageable = PageRequest.of(page-1,30,Sort.by("cost"));
        }
        else if(method ==3){
            pageable = PageRequest.of(page-1,30,Sort.by("cost").descending());
        }
        else
            pageable = PageRequest.of(page-1,30,Sort.by("title"));
        Page<Post> posts;

        Category[] categories =Category.values();
            posts = postRepository.findByCategory(pageable,categories[cate_num]);

        return ResponseDto.success(posts);
    }
    @Transactional
    public ResponseDto<?> createPost(RequestPostDto  requestPostDto) {
        Post post = Post.builder()
                .imgUrl(requestPostDto.getImgUrl())
                .title(requestPostDto.getTitle())
                .desc(requestPostDto.getDesc())
                .manual(requestPostDto.getManual())
                .cost(requestPostDto.getCost())
                .point(requestPostDto.getPoint())
                .cnt(0)
                .category(requestPostDto.getCategory())
                .build();
        postRepository.save(post);
        return ResponseDto.success("Success");

    }

    @Transactional
    public ResponseDto<?> deletePost(Long id) {
        Post post = isPresentPost(id);
        postRepository.delete(post);
        return ResponseDto.success("Success");

    }
    @Transactional
    public ResponseDto<?> getPost(Long id) {
        Post post = isPresentPost(id); //찾아서 ++;
        post.add_cnt();

        return ResponseDto.success(ResponsePostDto.builder()
                .imgUrl(post.getImgUrl())
                .title(post.getTitle())
                .desc(post.getDesc())
                .manual(post.getManual())
                .cost(post.getCost())
                .point(post.getPoint())
                .cnt(post.getCnt())
                .category(post.getCategory())
                .build()
        );

    }
    @Transactional(readOnly = true)
    public Post isPresentPost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElse(null);
    }

}
