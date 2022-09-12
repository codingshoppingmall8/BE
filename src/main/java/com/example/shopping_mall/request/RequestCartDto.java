package com.example.shopping_mall.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCartDto {
    private String imgUrl;
    private String title;
    private String desc;
    private int cost;
}
