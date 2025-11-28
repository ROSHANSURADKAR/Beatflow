package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.entity.user;

import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Long> {
    Optional<user> findByEmail(String email);
}
