package com.example.testsecurity.repository;

import com.example.testsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserId(String username);

    Optional<User> findByUserId(String username);

}
