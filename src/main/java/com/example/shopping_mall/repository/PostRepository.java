package com.example.shopping_mall.repository;


import com.example.shopping_mall.Entity.Category;
import com.example.shopping_mall.Entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;


public interface PostRepository  extends JpaRepository<Post,Long> {


        Page<Post> findByCategory(Pageable pageable, Category Category);



}
