# ðíë¡ì í¸ëª : One more bag [ì¼íëª° í´ë¡ ì½ë©]

#### íë¡ì í¸ ì¤ëª : https://onemorebag.kr/product/list.html?cate_no=45 ì¹ì¬ì´í¸ í´ë¡ ì½ë©
##### íë¡ì í¸ ê¸°ê°: 22/9/9-15
<img width="1757" alt="áá³áá³ááµá«áá£áº 2022-09-15 áá©áá® 1 13 38" src="https://user-images.githubusercontent.com/104494969/190312656-94c2cfd5-2dcb-470f-8b94-2a12e3f3ed42.png">

#####  ìë² ë°°í¬: http://hyerimawsbucket.s3-website.ap-northeast-2.amazonaws.com/
##### FE Github : origin[https://github.com/jamie7dev/W7_One_more_bag.git]
##### FE Github organization - origin2[https://github.com/codingshoppingmall8/FE]
##### BE Github : [https://github.com/codingshoppingmall8/BE]

## ð¨âð¦âð¦Team Members
**[FE] Hye-rim-Lee, Chae-won-Yoon** <br>
**[BE] Sun-Hong-Lee, Dong-Ha-Shin, Ha-Young-Kim**

## âTech Stack
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white"/>
<img src="https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB"/>
<img src="https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white"/>
<img src="https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white"/>
<img src="https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E"/>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"/>
<img src="https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white"/>
<img src="https://img.shields.io/badge/kakaotalk-ffcd00.svg?style=for-the-badge&logo=kakaotalk&logoColor=000000"/>
<img src="https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white"/>
<img src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white"/>
<img src="https://img.shields.io/badge/Visual Studio Code-007ACC.svg?style=for-the-badge&logo=Visual Studio Code&logoColor=white"/>
<img src="https://img.shields.io/badge/Amazon Web Service-232F3E?style=for-the-badge&logo=Amazon%20AWS&logoColor=white"/>

## ð¾ERD
![image](https://user-images.githubusercontent.com/67679972/190326599-51dfb9a8-8e60-45f8-85ea-711b7c2f26cc.png)
<br>

## ðapiëªì¸ì
ë§í¬ : https://nonchalant-sturgeon-21a.notion.site/8-d8cd94d7525843618ebc766da876d5d0
|ê¸°ë¥|ë©ìë|URL|
|------|---|---|
|ì´ë©ì¼ì¤ë³µì²´í¬|GET|api/member/signup|
|íìê°ì|POST|api/member/signup|
|ë¡ê·¸ì¸|POST|api/member/login|
|ì¹´ì¹´ì¤ ë¡ê·¸ì¸|GET|api/member/kakao|
|ë©ì¸íì´ì§ ê°ì ¸ì¤ê¸°|GET|api/post?page=|
|ë©ì¸íì´ì§ ì ë ¬|GET|api/sort_post?page= &sort_method=|
|ì¹´íê³ ë¦¬ë³ë¡ ê°ì ¸ì¤ê¸°|GET|api/post_category?page=&cate_no=|
|ì¹´íê³ ë¦¬ë³ë¡ ì ë ¬|GET|api/post_category?page=&cate_n&sort_method=|
|ìì¸íì´ì§ ê°ì ¸ì¤ê¸°|GET|api/post/{id}|
|ë§ì´íì´ì§ ê°ì ¸ì¤ê¸°|GET|api/member/mypage|
|ë§ì´íì´ì§ ìì |POST|api/member/mypage|
|ì¥ë°êµ¬ë ë´ê¸°|POST|api/member/cart/{id}|
|ì¥ë°êµ¬ë ì¡°í|GET|api/member/cart|
|ì¥ë°êµ¬ë ì­ì |DELETE|api/member/cart|
|ì¥ë°êµ¬ë ì ì²´ì­ì |DELETE|api/member/cart/deleteAll|
|ê²ìê¸ ë±ë¡|GET|api/member/cart|
|ê²ìê¸ ì­ì |DELETE|api/member/cart{id}|
<br>


## ðê¸°ë¥ êµ¬í List

1. **íìê°ì**
    - **Email ì¤ë³µ ê²ì¬**
    - **Email ì í¨ì± ê²ì¬**
    - **PW ë° PW Confirm ì í¨ì± ê²ì¬**
    - **í´ëì í ì í¨ì± ê²ì¬**
    
2. **ë¡ê·¸ì¸**
    - **Email, PW ìë ¥ì ê³µë°± ì í¨ì± ê²ì¬**
    - **Email, PW ì¼ì¹ ê²ì¬**
    - **Access Tokenê³¼ Refresh Tokenì Cookieì ì ì¥íê³  interceptor ì¬ì©
       ëª¨ë  íì´ì§ìì ë¡ê·¸ì¸ ì ì§**
    - **ìì ë¡ê·¸ì¸ êµ¬í(ì¹´ì¹´ì¤) Tokenì localStorageì ì ì¥**   
3. **ë§ì´íì´ì§**
    - **íì ì ë³´ ìì  (ì´ë¦, ì£¼ì, í´ëì í)**
    
4. **ë©ì¸ íì´ì§**
   - **ìí ì¹´íê³ ë¦¬ë³ ì ë ¬**
    - **Pagination**
    - **ì ìí/ìíëª/ë®ìê°ê²©/ëìê°ê²©/ì¡°íì ì ë ¬**
    - **css(ì¤í¬ë¡¤ì í¤ë ê³ ì , grid, ë°ìí ì¹íì´ì§)**
    
5. **ì¥ë°êµ¬ë**
    - **ì¥ë°êµ¬ëì ìí ì¶ê°, ê°ë³ ì­ì **
    - **checkbox ì ì²´ ì í, í´ì , ì í ì­ì **
    - **ì¥ë°êµ¬ë ë¹ì°ê¸° (ëª©ë¡ ì ì²´ ì­ì )**


-----------------

## Front) ð¡TroubleShooting 

- A component is changing a controlled input to be uncontrolled.    
    ìì¸) input íê·¸ì value ì´ê¸°ê°ì´ undefinedìë¤ê° ë ëë§ íì ê°ì´ ë¤ì´ì ë°ëë©´ì ë°ìí ìë¬    
    í´ê²°) input íê·¸ valueì ê³µë°±ì ì¤ì ||'' controlled inputì ë²ì£¼ì í¬í¨ìì¼ì£¼ë©´ ë¨    
        ì) value={arr[i]|| ''}    
   
- ì¥ë°êµ¬ë ëª©ë¡ìì ê°ë³ ì­ì ê° ì ë¨ 400ìë¬    
    ìì¸) payloadë¥¼ ìëª» ë³´ë    
    í´ê²°) axios.deleteë dataë¥¼ bodyì ë´ì ë data:{}ë¡ ê°ì¸ì ë³´ë´ì¤ì¼ íë¤ê³  í¨.    
      ì) Axios.delete(`/posts/${id}`, {data:{posts: posts}})    
      
- íìì ë³´ê° ìë íìì´ ì¼ë°ë¡ê·¸ì¸ì ìëí  ì ë¡ê·¸ì¸ëë©°, ì¿ í¤ì í í°ì´ undefinedë¡ ì ì¥ëë ë¬¸ì    
ì´ë¡ ì¸í´ ì¤ì  íìì´ ìëì´ë ë¡ê·¸ì¸ì´ ë ê²ì¼ë¡ ë°ìë¤ì¬ì ¸ í¤ëì ì¡°ê±´ë¶ ë ëë§ì´ ì ì©ëì´ ë¡ê·¸ìì, ë§ì´íì´ì§, ì¥ë°êµ¬ë ë²í¼ì´ ë³´ìì   
  ìì¸) ë¡ê·¸ì¸ ë²í¼ì ëë ì ì íìì¸ì§ íì¸í ë¤ POSTìì²­ì ë³´ë´ì§ ìê³ , inputì ìë ¥ì¬ë¶ë§ íì¸íê³  ììì   
  í´ê²°) ë¡ê·¸ì¸ íì´ì§ìì GETìì²­ì¼ë¡ íìemailì ë°ìì¨ ë¤, ìë ¥í ì´ë©ì¼ê³¼ ì¼ì¹íë ì´ë©ì¼ì´ ìì ê²½ì° ë¡ê·¸ì¸ì ë§ìì£¼ì´ ì¿ í¤ì í í°ì´ undefinedë¡ ì ì¥ëì§ ëª»íê² ì²ë¦¬
    
- ì¹´ì¹´ì¤ ë¡ê·¸ì¸ ê¸°ë¥ êµ¬íì ìë£í ìì ë¶í° ì¼ë°ë¡ê·¸ì¸ì ìëíì ë ìì²­í¤ëì Authorizationê³¼ refreshTokenì´ nullë¡ ë¤ì´ê°ë©° ë¡ê·¸ì¸ì´ ëì§ ìë ë¬¸ì    
ìì¸) api.js íì¼ì ìì²­ì¸í°ìí° ì½ëë¥¼ ìëª» ìì±í¨. ì¡°ê±´ë¬¸ì ê±¸ì§ ìì ì½ëê° ìì°¨ì ì¼ë¡ ì½íë©° ìì²­í¤ëì ìë í í°ì ì¤ì´ì£¼ë ííê° ë¨.   
í´ê²°) ìì²­ì¸í°ìí° ì½ëë¥¼ ifë¬¸ì¼ë¡ ìì í¨.   
ì¼ë° ë¡ê·¸ì¸ì tokenì ì¿ í¤ì ì ì¥íê³ , ì¹´ì¹´ì¤ ë¡ê·¸ì¸ì tokenì ë¡ì»¬ì¤í ë¦¬ì§ì ì ì¥íëë°,    
ifë¬¸ì¼ë¡ ì¡°ê±´ì ê±¸ì´ì ì¹´ì¹´ì¤ ë¡ê·¸ì¸ ìì íìí ë¡ì»¬ì¤í ë¦¬ì§ì ìë AccessTokenì´ nullì¼ ê²½ì° ì¿ í¤ìì ê°ì ¸ì¨ í í°ë¤ì ìì²­í¤ëì ì¤ì´ì£¼ê³ ,    
ë¡ì»¬ì¤í ë¦¬ì§ì AccessTokenì´ ìì ê²½ì° í¤ëì ë¡ì»¬ì¤í ë¦¬ì§ìì ê°ì ¸ì¨ í í°ë¤ì ë³´ë´ë ì½ëë¥¼ ìì±í¨
    ```
    if (AccessToken === null) {
            config.headers.Authorization = token;
            config.headers.refreshToken = refreshToken;
        } else {
            config.headers.Authorization = AccessToken;
            config.headers.refreshToken = RefreshToken;
        };
	```     
      
## Back) ð¡TroubleShooting  

- postmanì¼ë¡ Long íì ë¦¬ì¤í¸ë¥¼ ì£¼ëë° controllerìì ê·¸ ê°ì ëª» ë°ì    
    ìì¸) postmanììë jsoníìì¼ë¡ listë¥¼ ì ê³µíëë° ì¼ë° List ê°ì²´ë ì´ê°ì ë°ì§ ëª»í¨. <br>
    í´ê²°) Longíì Listë¥¼ ê°ì§ë dto í´ëì¤ë¥¼ ìì±íê³  controllerìì ì´ dtoë¥¼ íµí´ Listë¥¼ ì ë¬ë°ì.
    
- pageë¡ ì ë ¬ë ê²ìê¸ ë¦¬ì¤í¸ë¤ì returní  ë ë¶íìí ê°ë¤ê¹ì§ returnë¨(ex createdAt,cnt..postì fieldë¤)   
    ìì¸) Postí Pageë¤ì ë¦¬í´ì íê¸° ëë¬¸ì ë°ìí ë¬¸ì .<br>
    í´ê²°) ë¨¼ì  postìì íìí ì ë³´ë¤ì ë°ë dtoê°ì²´ë¥¼ ìì±ì íê³  í´ëì¤ ë´ë¶ì postê°ì²´ë¥¼ ë°ì¼ë©´ dto Listë¥¼ ë°ííë
          ë©ìëë¥¼ ìì±. ì´ë¥¼ ì´ì©í´ì Page<Post>ë¥¼ ë°íì íë ê²ì´ ìëë¼ Page<Postdto>ë¥¼ ë°íí¨.
    
- ì¹´ì¹´ì¤ ë¡ê·¸ì¸ì Kakao Rest API "Redirect URI mismatch." ìë¬   
    ìì¸) íë¡ í¸ìëìì ì¸ê°ì½ë ë°ìë Redirect URIê° ë°±ìëìì ì¡ì¸ì¤í í°ì ë°ìë Redirect URIì´ ë¬ë¼ì ìê¸´ ë¬¸ì .<br>
    í´ê²°) ì¡ì¸ì¤ í í°ì ë°ìë Redirect URIì   íë¡ í¸ì ëê°ì´ í´ì¤ì¼ë¡ì¨ í´ê²°<br>
       ì) ("redirect_uri", "http://localhost:8080/kakao")  ->  ("redirect_uri", "http://localhost:3030/kakao") 

- ì¼íëª°ì ì¡´ì¬íë 1000ê°ì§ ì´ìì ë°ì´í° ê°ì ¸ì¤ë ë°©ë²
     ì¼íëª°ì ìë ìí ì ë³´ë¥¼ ì¼ì¼ì´ ìììì¼ë¡ ê°ì ¸ì¤ëê±´ ë¹í¨ì¨ì ì´ë¼ê³  íë¨íì¬ íì´ì¬ì¼ë¡ ì¼íëª°ì ìë ìí ì ë³´ë¥¼ í¬ë¡¤ë§íì¬ ìë² DBìë¤ ì ì¥íìë¤.<br>
     ë°ë¼ì ìììì¼ë¡ íì¤ ìììì ìê° 6ìê° ê±¸ë¦¬ë ììì 30ë¶ì¼ë¡ ì¶ìí­ ì ìì<br>
     
    
<details>
    <summary>
	 <b>í¬ë¡¤ë§ ëì ì½ë python</b>
    </summary> 
	
```python
<br>
# urlë¡ html ë°ìì¤ê¸°
url = "https://www.onemorebag.kr/product/list.html?cate_no=676&page=5"
scraper = cfscrape.create_scraper()
r = scraper.get(url)
r.status_code  # 200

# id ê°ì´ normal-products-containerì¸ ul íê·¸ë§ ê°ì ¸ì¤ê¸° 
soup = BeautifulSoup(r.content.decode('utf-8'), "lxml")
cartoonsBox = soup.find('ul', attrs={"id": "normal-products-container"})

# a íê·¸ ë§ ì ì¥ 
cartoons = cartoonsBox.find_all('a')
post_url_list = []
post_img_url_list = []

for idx,val in enumerate(cartoons):
  if idx % 2 == 0:
    print(val.findChild("img")['src']) # ì´ë¯¸ì§ ì£¼ì
    post_img_url_list.append(val.findChild("img")['src'])
    print(val.get('href')) # ìí ìì¸íì´ì§ ì£¼ì
    post_url_list.append(val.get('href'))
  else: 
    print(str(val)[:-11].split('style="font-size:12px;color:#555555;">')[-1] ) # ìí ì ëª©
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

# ë¬¸ìì´ ì¶ì¶   ê°ê²©ê³¼ í¬ì¸í¸ë ë¬¸ìì´ 
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
      point = s.split('ì')[0].replace(',','')
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


## ð¥ìì¬ì´ ì  
1. ìì¸íì´ì§ìì ë¤ë¡ê°ê¸°ë¥¼ íë©´ ë©ì¸ ì²« íì´ì§ë¡ ëìê°
2. ê´ë¦¬ì íì´ì§
    - ìí ë±ë¡
    - íìê´ë¦¬
    
   
