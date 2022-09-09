package com.example.shopping_mall.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberRequestDto {
    private Long id;

    private String email;

    private String password;

    private String passwordConfirm;

    private String name;

    private String address;

    private int phone;
}
