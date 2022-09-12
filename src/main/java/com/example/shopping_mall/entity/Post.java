package com.example.shopping_mall.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String imgUrl;
    @Column
    private String title;
    @Column
    private String desc;
    @Column
    private int cost;
    @Column
    private int point;//point
    @Column
    private int cnt;//조회수를 더하기 위한 field
    @Column
    private Category category;
    @CreationTimestamp
    @Column
    private LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt = LocalDateTime.now();
    public void add_cnt(){
        this.cnt++;
    }
}
