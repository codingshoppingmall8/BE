package com.example.shopping_mall.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String imgUrl;
    @Column
    private String title;
    @Column
    private String desc;
    @Column
    private int cost;


    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;


    @CreationTimestamp
    @Column
    private LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt = LocalDateTime.now();
}
