package com.example.shopping_mall.service;

import com.example.shopping_mall.entity.Member;
import com.example.shopping_mall.jwt.TokenProvider;
import com.example.shopping_mall.repository.MemberRepository;
import com.example.shopping_mall.request.LoginRequestDto;
import com.example.shopping_mall.request.MemberRequestDto;
import com.example.shopping_mall.request.TokenDto;
import com.example.shopping_mall.response.MemberResponseDto;
import com.example.shopping_mall.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Target;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    //  private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;


    @Transactional
    public ResponseDto findAllEmail(){
        List<String> emailList = new ArrayList<>();
        List<Member> memberList = memberRepository.findAll();
        for(Member temp:memberList){
            emailList.add(temp.getEmail());
        }
        return ResponseDto.success(emailList);
    }

    @Transactional
    public ResponseDto<?> createMember(MemberRequestDto requestDto) {
        if (null != isPresentMember(requestDto.getEmail())) {
            return ResponseDto.fail("DUPLICATED_NICKNAME",
                    "중복된 EMAIL 입니다.");
        }

        if (!isPassword((requestDto.getPassword()))) {
            return ResponseDto.fail("Password_NOT_MATCHED_RULE",
                    "비밀번호 입력 형식이 잘못되었습니다.(영문+숫자 4~12자리)");
        }
        if (!requestDto.getPassword().equals(requestDto.getPasswordConfirm())) {
            return ResponseDto.fail("PASSWORDS_NOT_MATCHED",
                    "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        if(!isEmail(requestDto.getEmail())){
            return ResponseDto.fail("Email_NOT_MATCHED_RULE",
                    "이메일 입력 형식이 잘못되었습니다.");
        }
        if(!isPhoneNumber(requestDto.getPhone())){
            return ResponseDto.fail("PHONE_NUMBER_NOT_MATCHED_RULE",
                    "전화번호 입력 형식이 잘못되었습니다.(숫자 11자리)");
        }
        Member member = Member.builder()
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .name(requestDto.getName())
                .phone(requestDto.getPhone())
                .address(requestDto.getAddress())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .build();
        memberRepository.save(member);

        return ResponseDto.success(
                MemberResponseDto.builder()
                        .id(member.getId())
                        .name(member.getName())
                        .build()
        );
    }

    @Transactional
    public ResponseDto<?> login(LoginRequestDto requestDto, HttpServletResponse response) {
        Member member = isPresentMember(requestDto.getEmail());
        if (null == member) {
            return ResponseDto.fail("MEMBER_NOT_FOUND",
                    "사용자를 찾을 수 없습니다.");
        }

        if (!member.validatePassword(passwordEncoder, requestDto.getPassword())) {
            return ResponseDto.fail("INVALID_MEMBER", "패스워드가 틀렸습니다.");
        }

//    UsernamePasswordAuthenticationToken authenticationToken =
//        new UsernamePasswordAuthenticationToken(requestDto.getNickname(), requestDto.getPassword());
//    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        TokenDto tokenDto = tokenProvider.generateTokenDto(member);
        tokenToHeaders(tokenDto, response);

        return ResponseDto.success(
                MemberResponseDto.builder()
                        .id(member.getId())
                        .name(member.getName())
                        .build()
        );
    }

    //  @Transactional
//  public ResponseDto<?> reissue(HttpServletRequest request, HttpServletResponse response) {
//    if (!tokenProvider.validateToken(request.getHeader("Refresh-Token"))) {
//      return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
//    }
//    Member member = tokenProvider.getMemberFromAuthentication();
//    if (null == member) {
//      return ResponseDto.fail("MEMBER_NOT_FOUND",
//          "사용자를 찾을 수 없습니다.");
//    }
//
//    Authentication authentication = tokenProvider.getAuthentication(request.getHeader("Access-Token"));
//    RefreshToken refreshToken = tokenProvider.isPresentRefreshToken(member);
//
//    if (!refreshToken.getValue().equals(request.getHeader("Refresh-Token"))) {
//      return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
//    }
//
//    TokenDto tokenDto = tokenProvider.generateTokenDto(member);
//    refreshToken.updateValue(tokenDto.getRefreshToken());
//    tokenToHeaders(tokenDto, response);
//    return ResponseDto.success("success");
//  }
    public ResponseDto<?> deleteMember(HttpServletRequest request) {
        Member member = validateMember(request);
        memberRepository.delete(member);
        return ResponseDto.success("왜 안되");
    }

    public ResponseDto<?> logout(HttpServletRequest request) {
        if (!tokenProvider.validateToken(request.getHeader("RefreshToken"))) {
            return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
        }
        Member member = tokenProvider.getMemberFromAuthentication();
        if (null == member) {
            return ResponseDto.fail("MEMBER_NOT_FOUND",
                    "사용자를 찾을 수 없습니다.");
        }

        return tokenProvider.deleteRefreshToken(member);
    }

    @Transactional(readOnly = true)
    public Member isPresentMember(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        return optionalMember.orElse(null);
    }

    public void tokenToHeaders(TokenDto tokenDto, HttpServletResponse response) {
        response.addHeader("Authorization", "Bearer " + tokenDto.getAccessToken());
        response.addHeader("RefreshToken", tokenDto.getRefreshToken());
        response.addHeader("Access-Token-Expire-Time", tokenDto.getAccessTokenExpiresIn().toString());
    }

    @Transactional
    public Member validateMember(HttpServletRequest request) {
        if (!tokenProvider.validateToken(request.getHeader("RefreshToken"))) {
            return null;
        }
        return tokenProvider.getMemberFromAuthentication();
    }

    @Transactional(readOnly = true)
    public boolean isEmail(String email){
        String regx = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    @Transactional(readOnly = true)
    public boolean isPhoneNumber(String number){
        if(number.length()!=11)
            return false;
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();

    }

    @Transactional(readOnly = true)
    public boolean isPassword(String password){
        Pattern pattern = Pattern.compile("^.*(?=^.{4,12}$)(?=.*\\d)(?=.*[a-zA-Z]).*$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
