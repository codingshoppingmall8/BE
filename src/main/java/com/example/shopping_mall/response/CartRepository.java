package com.example.shopping_mall.response;

import com.example.shopping_mall.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
