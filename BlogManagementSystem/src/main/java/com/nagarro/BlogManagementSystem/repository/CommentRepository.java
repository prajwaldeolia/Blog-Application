package com.nagarro.BlogManagementSystem.repository;

import com.nagarro.BlogManagementSystem.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Add additional methods if needed
}
