package com.gul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gul.entity.UserOtp;

public interface UserOtpRepository extends JpaRepository<UserOtp, Long> {

	UserOtp findByEmailAndOtp(String email, String otp);

	UserOtp findByEmail(String email);
}
