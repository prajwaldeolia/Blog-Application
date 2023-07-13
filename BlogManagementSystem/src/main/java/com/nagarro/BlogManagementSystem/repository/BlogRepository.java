package com.nagarro.BlogManagementSystem.repository;

import com.nagarro.BlogManagementSystem.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Add additional methods if needed
}
