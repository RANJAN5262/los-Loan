package com.loan.repository;

import com.loan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User name(String name);

    User findByEmail(String email);
}
