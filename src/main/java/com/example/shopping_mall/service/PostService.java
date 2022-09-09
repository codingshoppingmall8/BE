package com.example.shopping_mall.service;

import com.example.shopping_mall.Entity.Post;
import com.example.shopping_mall.repository.PostRepository;
import com.example.shopping_mall.request.RequestPostDto;
import com.example.shopping_mall.response.ResponseDto;
import com.example.shopping_mall.response.ResponsePostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostService {
    private  final PostRepository postRepository;


    @Transactional
    public ResponseDto<?> getPostList(Long id) {
        Post post = isPresentPost(id);
        postRepository.delete(post);
        return ResponseDto.success("Success");

    }

    @Transactional
    public ResponseDto<?> createPost(RequestPostDto  requestPostDto) {
//        if (null == request.getHeader("Refresh-Token")) {
//            return ResponseDto.fail("MEMBER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        if (null == request.getHeader("Authorization")) {
//            return ResponseDto.fail("MEMBER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
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
