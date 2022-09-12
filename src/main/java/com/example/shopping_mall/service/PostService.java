package com.example.shopping_mall.service;

import com.example.shopping_mall.entity.Category;
import com.example.shopping_mall.entity.Post;
import com.example.shopping_mall.repository.PostRepository;
import com.example.shopping_mall.request.RequestPostDto;
import com.example.shopping_mall.response.ResponseDto;
import com.example.shopping_mall.response.ResponsePostDto;
import com.example.shopping_mall.response.ResponsePostDto2;
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
    private final PostRepository postRepository;

    @Transactional
    public ResponseDto<?> getAllPost(int page) { //전체 리스트를 return
        Pageable pageable = PageRequest.of(page - 1, 30, Sort.by("createdAt").descending());//기본값으로 최신순으로 정렬됨
        Page<Post> posts = postRepository.findAll(pageable);
        Page<ResponsePostDto> responsePostDtoPage = new ResponsePostDto().toDtoList(posts);
        return ResponseDto.success(responsePostDtoPage);
    }

    @Transactional
    public ResponseDto<?> allPostSort(int page, int method) { //전체 리스트 정렬 할때 .
        Pageable pageable;
        if (method == 1) {
            pageable = PageRequest.of(page - 1, 30, Sort.by("cnt").descending());
        } else if (method == 2) {
            pageable = PageRequest.of(page - 1, 30, Sort.by("cost"));
        } else if (method == 3) {
            pageable = PageRequest.of(page - 1, 30, Sort.by("cost").descending());
        } else
            pageable = PageRequest.of(page - 1, 30, Sort.by("title"));
        Page<Post> posts = postRepository.findAll(pageable);//전체를 그냥 조회 할 때
        Page<ResponsePostDto> responsePostDtoPage = new ResponsePostDto().toDtoList(posts);
        return ResponseDto.success(responsePostDtoPage);
    }

    @Transactional
    public ResponseDto<?> getPostByCategory(int page, int cate_num) { //전체 리스트를 return
        Pageable pageable = PageRequest.of(page - 1, 30, Sort.by("createdAt").descending());//기본값
        Page<Post> posts;
        Category[] categories = Category.values();
        posts = postRepository.findByCategory(pageable, categories[cate_num]);
        Page<ResponsePostDto> responsePostDtoPage = new ResponsePostDto().toDtoList(posts);
        return ResponseDto.success(responsePostDtoPage);
    }

    @Transactional
    public ResponseDto<?> sortPostsByCategory(int page, int cate_num, int method) {
        Pageable pageable;
        if (method == 1) {
            pageable = PageRequest.of(page - 1, 30, Sort.by("cnt").descending());
        } else if (method == 2) {
            pageable = PageRequest.of(page - 1, 30, Sort.by("cost"));
        } else if (method == 3) {
            pageable = PageRequest.of(page - 1, 30, Sort.by("cost").descending());
        } else
            pageable = PageRequest.of(page - 1, 30, Sort.by("title"));
        Page<Post> posts;

        Category[] categories = Category.values();
        posts = postRepository.findByCategory(pageable, categories[cate_num]);
        Page<ResponsePostDto> responsePostDtoPage = new ResponsePostDto().toDtoList(posts);

        return ResponseDto.success(responsePostDtoPage);
    }

    @Transactional
    public ResponseDto<?> createPost(RequestPostDto requestPostDto) {
        Post post = Post.builder()
                .imgUrl(requestPostDto.getImgUrl())
                .brand(requestPostDto.getBrand())
                .title(requestPostDto.getTitle())
                .desc(requestPostDto.getDesc())
                .cost(requestPostDto.getCost())
                .point(requestPostDto.getPoint())
                .cnt(0)//초기 조회수는 0인것임!
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

        return ResponseDto.success(ResponsePostDto2.builder()
                .imgUrl(post.getImgUrl())
                .brand(post.getBrand())
                .title(post.getTitle())
                .desc(post.getDesc())
                .cost(post.getCost())
                .point(post.getPoint())
                .cnt(post.getCnt())
                .build()
        );
    }

    @Transactional(readOnly = true)
    public Post isPresentPost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElse(null);
    }


}
