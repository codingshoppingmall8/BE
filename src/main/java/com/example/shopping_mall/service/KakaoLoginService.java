package com.example.shopping_mall.service;

import com.example.shopping_mall.entity.Member;
import com.example.shopping_mall.entity.UserDetailsImpl;
import com.example.shopping_mall.jwt.TokenProvider;
import com.example.shopping_mall.repository.MemberRepository;
import com.example.shopping_mall.request.TokenDto;
import com.example.shopping_mall.response.ResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class KakaoLoginService {
    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;


    public ResponseDto<?> kakaoLogin(String code, HttpServletResponse response) throws JsonProcessingException {

        // 1. "인가 코드"로 "액세스 토큰" 요청
        String accessToken = getAccessToken(code);

        // 2. 토큰으로 카카오 API 호출
        String kakaoNickName = getKakaoUserInfo(accessToken);

        // 3. 필요시에 회원가입
        Member kakaoUser = registerKakaoUserIfNeeded(kakaoNickName);

        // 4. 강제 로그인 처리
        forceLogin(kakaoUser, response);

        return ResponseDto.success("성공");
    }

    private String getAccessToken(String code) throws JsonProcessingException {
        // HTTP Header 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HTTP Body 생성
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", "d808b4d11eaadb71d6b83d935725e200");
        body.add("redirect_uri", "http://43.201.34.71:8080/api/member/kakao");
        body.add("code", code);

        // HTTP 요청 보내기
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(body, headers);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        // HTTP 응답 (JSON) -> 액세스 토큰 파싱
        String responseBody = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        return jsonNode.get("access_token").asText();
    }

    private String getKakaoUserInfo(String accessToken) throws JsonProcessingException {
        // HTTP Header 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HTTP 요청 보내기
        HttpEntity<MultiValueMap<String, String>> kakaoUserInfoRequest = new HttpEntity<>(headers);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoUserInfoRequest,
                String.class
        );

        String responseBody = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
//        Long id = jsonNode.get("id").asLong();
        String nickname = jsonNode.get("properties")
                .get("nickname").asText();
        String email = jsonNode.get("kakao_account")
                .get("email").asText();

//        System.out.println("카카오 사용자 정보: "  + nickname);
        return email;
    }


    private Member registerKakaoUserIfNeeded(String email) {
        // DB 에 중복된 Kakao 닉네임이 있는지 확인
        Member kakaoUser = memberRepository.findByEmail(email)
                .orElse(null);

        if (kakaoUser == null) {

            // password: random UUID
            String password = UUID.randomUUID().toString();
            String encodedPassword = passwordEncoder.encode(password);

            //새로운 맴버 추가
            kakaoUser = Member.builder()
                    .email(email)
                    .password(encodedPassword)
                    .name("kakaoUser")
                    .build();
            return memberRepository.save(kakaoUser);
        }
        return kakaoUser;
    }

    private void forceLogin(Member kakaoUser, HttpServletResponse response) {
        UserDetails userDetails = new UserDetailsImpl(kakaoUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //여기부터 토큰 프론트에 넘기는것
        UserDetailsImpl userDetails1 = ((UserDetailsImpl) authentication.getPrincipal());
        TokenDto tokenDto = tokenProvider.generateTokenDto(kakaoUser);
//        response.addHeader("Authorization", "BEARER" + " " + tokenDto);
        response.addHeader("Authorization", "Bearer " + tokenDto.getAccessToken());
        response.addHeader("RefreshToken", tokenDto.getRefreshToken());
        response.addHeader("Access-Token-Expire-Time", tokenDto.getAccessTokenExpiresIn().toString());
//        System.out.println(tokenDto.getAccessToken());
//        System.out.println(tokenDto.getRefreshToken());

    }
}
