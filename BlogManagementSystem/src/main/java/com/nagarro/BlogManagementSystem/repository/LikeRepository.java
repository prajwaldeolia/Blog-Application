package com.nagarro.BlogManagementSystem.repository;

import com.nagarro.BlogManagementSystem.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    // Add additional methods if needed
}
