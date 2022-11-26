package com.tweetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailId(String username);

	boolean existsByEmailId(String emailId);
	

}
