package com.example.shopping_mall.Entity;


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
    @JoinColumn(name = "post_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;


    @CreationTimestamp
    @Column
    private LocalDateTime createdAt = LocalDateTime.now();
    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt = LocalDateTime.now();
}
