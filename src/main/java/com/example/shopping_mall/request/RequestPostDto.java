package com.example.shopping_mall.request;

import com.example.shopping_mall.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@NoArgsConstructor
@AllArgsConstructor

public class RequestPostDto {
    private String imgUrl;
    private String brand;
    private String title;
    private String desc;//설명
    private int  cost;//가격 주문
    private int  point;//point
    private Category category;
}
