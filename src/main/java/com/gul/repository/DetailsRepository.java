package com.gul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gul.entity.PersonalDetails;

public interface DetailsRepository extends JpaRepository<PersonalDetails, Long> {

	PersonalDetails findByUid(long id);
}
