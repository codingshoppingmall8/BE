package com.example.shopping_mall.repository;

import com.example.shopping_mall.entity.Cart;
import com.example.shopping_mall.entity.Member;
import com.example.shopping_mall.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findAllByMember(Member member);

}
