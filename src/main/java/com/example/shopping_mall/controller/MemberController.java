package com.example.shopping_mall.controller;

import com.example.shopping_mall.request.LoginRequestDto;
import com.example.shopping_mall.request.MemberRequestDto;
import com.example.shopping_mall.request.MyPageRequestDto;
import com.example.shopping_mall.response.MyPageResponseDto;
import com.example.shopping_mall.response.ResponseDto;
import com.example.shopping_mall.service.MemberService;
import com.example.shopping_mall.service.KakaoLoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;
    private final KakaoLoginService kakaoLoginService;

    @PostMapping(value = "/api/member/signup")
    public ResponseDto<?> signup(@RequestBody @Valid MemberRequestDto requestDto) {
        return memberService.createMember(requestDto);
    }

    @GetMapping(value = "/api/member/signup")
    public ResponseDto<?> signup() {
        return memberService.findAllEmail();
    }

    @DeleteMapping(value = "/api/member")
    public ResponseDto<?> deleteMember(HttpServletRequest request) {
        return memberService.deleteMember(request);
    }

    @PostMapping(value = "/api/member/login")
    public ResponseDto<?> login(@RequestBody @Valid LoginRequestDto requestDto, HttpServletResponse response) {
        return memberService.login(requestDto, response);
    }

    @GetMapping(value = "/api/member/kakao")
    public ResponseDto<?> kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        return kakaoLoginService.kakaoLogin(code, response);
    }

    @PostMapping(value = "/api/auth/member/logout")
    public ResponseDto<?> logout(HttpServletRequest request) {
        return memberService.logout(request);
    }

    @GetMapping(value = "api/member/mypage")
    public ResponseDto<?> getMyPage(HttpServletRequest request){
        return memberService.getMyPage(request);
    }

    @PostMapping(value = "api/member/mypage")
    public ResponseDto<?> updateMyPage(@RequestBody MyPageRequestDto requestDto, HttpServletRequest request){
        return memberService.updateMyPag(requestDto, request);
    }

}
