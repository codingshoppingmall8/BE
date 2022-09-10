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
public class ResponsePostDto {
    private String imgUrl;
    private String title;
    private String desc;//설명
    private String manual;//상세 정보
    private int  cnt;//point
    private int  cost;//point
    private int  point;//point
    private Category category;
}
