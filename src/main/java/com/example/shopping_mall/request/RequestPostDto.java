package com.example.shopping_mall.request;

import com.example.shopping_mall.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@NoArgsConstructor
@AllArgsConstructor

public class RequestPostDto {
    private String imgUrl;
    private String title;
    private String desc;//설명
    private String manual;//상세 정보
    private int  cost;//point
    private int  point;//point
    private Category category;
}
