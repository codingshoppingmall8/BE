package com.example.shopping_mall.controller;


import com.example.shopping_mall.request.MemberRequestDto;
import com.example.shopping_mall.response.ResponseDto;
import com.example.shopping_mall.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class CartController {
    private final CartService cartService;
    @PostMapping(value = "api/member/cart/{id}")
    public ResponseDto<?> addCart(@PathVariable("id") Long id, HttpServletRequest request) {
        return cartService.addCart(id,request);
    }
    @GetMapping(value = "api/member/cart")
    public ResponseDto<?> getAllCarts(HttpServletRequest request) {
        return cartService.getAllCart(request);
    }
}
