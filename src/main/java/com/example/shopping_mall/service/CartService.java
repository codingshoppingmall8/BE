package com.example.shopping_mall.service;


import com.example.shopping_mall.entity.Cart;
import com.example.shopping_mall.entity.Member;
import com.example.shopping_mall.entity.Post;
import com.example.shopping_mall.jwt.TokenProvider;
import com.example.shopping_mall.repository.PostRepository;
import com.example.shopping_mall.repository.CartRepository;
import com.example.shopping_mall.response.ResponseCartDto;
import com.example.shopping_mall.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final PostRepository postRepository;
    private final TokenProvider tokenProvider;

    @Transactional
    public ResponseDto<?> addCart(Long id, HttpServletRequest request) { //전체 리스트를 return// token이 있으면 그냥 member가 할당이 되는데 아니면,, 흑흑
        Post post = isPresentPost(id);//로그인되면 그냥 가능한디....
        Member member = validateMember(request);
        Cart cart = Cart.builder()
                .member(member)
                .imgUrl(post.getImgUrl())
                .title(post.getTitle())
                .cost(post.getCost())
                .build();
        cartRepository.save(cart);//근데 이제 여기서 member와의 연관관계가 필요함

        return ResponseDto.success("SUCCESS");
    }

    @Transactional
    public ResponseDto<?> getAllCart(HttpServletRequest request) {
        Member member = validateMember(request);
        if(member.equals(null)){
            ResponseDto.fail("Login is required","로그인이 필요합니다.");
        }
        List<Cart> cartList = cartRepository.findAllByMember(member);//가져와서
        List<ResponseCartDto>responseCartDtoList = new ArrayList<>();
        for(Cart temp: cartList){
            responseCartDtoList.add(
                    ResponseCartDto.builder()
                            .id(temp.getId())
                            .imgUrl(temp.getImgUrl())
                            .title(temp.getTitle())
                            .cost(temp.getCost())
                            .build()
            );
        }
        return ResponseDto.success(responseCartDtoList);
    }

    @Transactional
    public ResponseDto<?> removeCart(HttpServletRequest request,List<Integer>chbox) { //chbox에서는 제거될 cart들의 id를 지칭함
        Member member = validateMember(request);
        if(member.equals(null)){
            ResponseDto.fail("Login is required","로그인이 필요합니다.");
        }
        for(Integer temp : chbox){
            Long idx = Long.valueOf(temp);
            cartRepository.deleteById(idx);
        }
        return ResponseDto.success("SUCCESS");
    }
    @Transactional(readOnly = true)//post를 찾아서 거기서 build를 하고 저장을 하는거임!
    public Post isPresentPost(Long id) {

        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isPresent()){
            return  optionalPost.get();
        }
        else{
            return null;
        }
    }
    @Transactional
    public Member validateMember(HttpServletRequest request) {
        if (!tokenProvider.validateToken(request.getHeader("RefreshToken"))) {
            return null;
        }
        return tokenProvider.getMemberFromAuthentication();
    }
}
