package com.nagarro.BlogManagementSystem.repository;

import com.nagarro.BlogManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Add additional methods if needed
}
