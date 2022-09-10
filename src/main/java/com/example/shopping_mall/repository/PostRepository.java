package com.example.shopping_mall.repository;


import com.example.shopping_mall.entity.Category;
import com.example.shopping_mall.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository  extends JpaRepository<Post,Long> {

        Page<Post> findByCategory(Pageable pageable, Category Category);

}
