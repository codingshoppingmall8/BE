package com.example.shopping_mall.response;



import com.example.shopping_mall.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponsePostDto2 {
    private String imgUrl;
    private String brand;
    private String title;
    private String desc;//설명
    private int  cost;//가격 주문
    private int  cnt;//가격 주문
    private int  point;//point

}
