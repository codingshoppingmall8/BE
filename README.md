# 쇼핑몰 클론 코딩
![image](https://user-images.githubusercontent.com/67679972/190193713-21dabc0c-48f0-4b0b-82da-73e842f29a94.png)
[클론한 사이트 주소](https://onemorebag.kr/product/list.html?cate_no=45)

<br>
<br>

## ⏰개발기간
2022년 9월 8일 ~ 2022년 9월 15일
<br>
<br>

## 😃프로젝트 개요
- 실제 운영되고 있는 쇼핑몰을 따라 만들면서 서비스 구현 능력을 향샹 시킨다.
- 새로운 기술을 학습한뒤 프로젝트에 구현 해본다.
- 클론 코딩을 하면서 부족한 점을 깨닫고 보완해 발전 시킨다.
<br>
<br>


## 🧍팀원 소개
### BE🖥
### 김하영, 신동하, 이선홍
### FE🖌
### 윤채원, 이혜림





## 📃api명세서
|기능|메소드|URL|
|------|---|---|
|이메일중복체크|GET|api/member/signup|
|회원가입|POST|api/member/signup|
|로그인|POST|api/member/login|
|카카오 로그인|GET|api/member/kakao|
|메인페이지 가져오기|GET|api/post?page=|
|메인페이지 정렬|GET|api/sort_post?page= &sort_method=|
|카테고리별로 가져오기|GET|api/post_category?page=&cate_no=|
|카테고리별로 정렬|GET|api/post_category?page=&cate_n&sort_method=|
|상세페이지 가져오기|GET|api/post/{id}|
|마이페이지 가져오기|GET|api/member/mypage|
|마이페이지 수정|POST|api/member/mypage|
|장바구니 담기|POST|api/member/cart/{id}|
|장바구니 조회|GET|api/member/cart|
|장바구니 삭제|DELETE|api/member/cart|
|장바구니 전체삭제|DELETE|api/member/cart/deleteAll|
|게시글 등록|GET|api/member/cart|
|게시글 삭제|DELETE|api/member/cart{id}|




