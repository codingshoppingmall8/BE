package com.example.shopping_mall.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCartDto {

    private Long id;
    private String imgUrl;
    private String title;
    private String desc;
    private int cost;

}
