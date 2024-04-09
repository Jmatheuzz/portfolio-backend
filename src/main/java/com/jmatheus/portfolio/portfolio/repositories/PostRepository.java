package com.jmatheus.portfolio.portfolio.repositories;


import com.jmatheus.portfolio.portfolio.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {


}
