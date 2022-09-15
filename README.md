# 쇼핑몰 클론 코딩
![image](https://user-images.githubusercontent.com/67679972/190193713-21dabc0c-48f0-4b0b-82da-73e842f29a94.png)
[클론한 사이트 주소](http://hyerimawsbucket.s3-website.ap-northeast-2.amazonaws.com/)

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
<br>
<br>

## 💾ERD
![image](https://user-images.githubusercontent.com/67679972/190326599-51dfb9a8-8e60-45f8-85ea-711b7c2f26cc.png)
<br>
<br>




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
<br>
<br>

## 트러블슈팅
<details>
    <summary>
        <b>쇼핑몰에 존재하는 1000가지 이상의 데이터 가져오는 방법</b>
    </summary>
<br>
  쇼핑몰에 있는 상품 정보를 일일이 수작업으로 가져오는건 비효율적이라고 판단하여 파이썬으로 쇼핑몰에 있는 상품 정보를 크롤링하여 서버 DB에다 저장하였다.
  따라서 수작업으로 하실 <b>예상소유시간 6시간 걸리는 작업을 30분으로 축소</b>할 수 있었다.
  

```python
	
#url = "https://onemorebag.kr/product/list.html?cate_no=45" 

# url로 html 받아오기
url = "https://www.onemorebag.kr/product/list.html?cate_no=676&page=5"
scraper = cfscrape.create_scraper()
r = scraper.get(url)
r.status_code  # 200

# id 값이 normal-products-container인 ul 태그만 가져오기 
soup = BeautifulSoup(r.content.decode('utf-8'), "lxml")
cartoonsBox = soup.find('ul', attrs={"id": "normal-products-container"})

# a 태그 만 저장 
cartoons = cartoonsBox.find_all('a')
post_url_list = []
post_img_url_list = []

for idx,val in enumerate(cartoons):
  if idx % 2 == 0:
    print(val.findChild("img")['src']) # 이미지 주소
    post_img_url_list.append(val.findChild("img")['src'])
    print(val.get('href')) # 상품 상세페이지 주소
    post_url_list.append(val.get('href'))
  else: 
    print(str(val)[:-11].split('style="font-size:12px;color:#555555;">')[-1] ) # 상품 제목
  print()

	server = 'http://43.201.34.71:8080/api/member/post'
category = 5
for idx,post_url_val in enumerate(post_url_list):
  post_url = "https://www.onemorebag.kr" + post_url_val

  scraper = cfscrape.create_scraper()
  r = scraper.get(post_url)
  r.status_code  # 200

  soup = BeautifulSoup(r.content.decode('utf-8'), "lxml")
  cartoonsBox = soup.find('div', attrs={"class": "xans-element- xans-product xans-product-detaildesign"})
  cartoons = cartoonsBox.find_all('td')

# 문자열 추출   가격과 포인트는 문자열 
  img_url = "http:" + post_img_url_list[idx]
  print("imgUrl : " + img_url)
  title_list = []
  brand_list = []
  desc_list = []
  cost_list = []
  point_list = []

  for idx,val in enumerate(cartoons):
    s = val.getText()
    if idx == 0:
      s = s.split(']')
      title = str(s[1])[1:]
      brand = str(s[0]).split('[')[-1]
    elif idx == 1:
      desc = s.replace('\r\n','-')
    elif idx == 2:
      cost=s[:-2].replace(',','')
    elif idx == 3:
      point = s.split('원')[0].replace(',','')
    elif idx == 4:
      continue
    #print(str(idx) + " " +s)
  print("brand : " + brand)
  print("title : " + title)
  print("desc : " + desc)
  print("cost : " + cost )
  print("point : " + point)
  response = requests.post(server, json={'imgUrl':img_url,'title': title, 'desc':desc,'cost':int(cost), 'point':int(point),'category':category,'brand':brand})
  print(response)
  print()
```

</details>
  <details>
    <summary>
        <b>카카오 로그인시 Kakao Rest API "Redirect URI mismatch." 에러 처리</b>
    </summary>
  <br>
  프론트엔드에서 인가코드 받을때 Redirect URI가 백엔드에서 액세스토큰을 받을때 Redirect URI이 달라서 생긴 문제이다. 따라서 백엔드에서 액세스 토큰을 받을때 Redirect URI을   프론트와 똑같이 해줌으로써 해결되었다.
  
</details>
  




