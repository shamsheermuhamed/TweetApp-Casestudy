package com.tweetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailId(String username);

	boolean existsByEmailId(String emailId);
	

}
