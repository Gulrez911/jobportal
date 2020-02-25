package com.gul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gul.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User findByEmailAndPasswordAndStatus(String email, String password, String status);

	User findByEmailAndStatus(String email, String status);
}
