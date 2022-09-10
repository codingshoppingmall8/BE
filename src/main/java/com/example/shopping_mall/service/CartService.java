package com.example.shopping_mall.service;


import com.example.shopping_mall.Entity.Cart;
import com.example.shopping_mall.Entity.Post;
import com.example.shopping_mall.repository.PostRepository;
import com.example.shopping_mall.request.RequestCartDto;
import com.example.shopping_mall.response.CartRepository;
import com.example.shopping_mall.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final PostRepository postRepository;

    @Transactional
    public ResponseDto<?> addCart(Long id) { //전체 리스트를 return
        Post post = isPresentPost(id);
        Cart cart = Cart.builder()
                .imgUrl(post.getImgUrl())
                .title(post.getTitle())
                .desc(post.getDesc())
                .cost(post.getCost())
                .build();
        cartRepository.save(cart);
        return ResponseDto.success("SUCCESS");

    }
    @Transactional(readOnly = true)
    public Post isPresentPost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElse(null);
    }
}
