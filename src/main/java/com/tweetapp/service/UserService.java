package com.tweetapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.entity.User;
import com.tweetapp.exception.UserAlreadyExistsException;
import com.tweetapp.repository.UserRepository;
import com.tweetapp.request.LoginRequest;
import com.tweetapp.request.ResetPasswordRequest;
import com.tweetapp.request.UserRequest;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public String addUser(UserRequest userRequest) {
		if(userRepository.existsByEmailId(userRequest.getEmailId())){
			throw new UserAlreadyExistsException();
		}
		User user=new User();
		user.setEmailId(userRequest.getEmailId());
		user.setName(userRequest.getName());
		user.setPassword(userRequest.getPassword());
		user.setLoggedIn(false);
		userRepository.save(user);
		return "User Registered Successfully!";
	}

	public String login(LoginRequest loginRequest) {
		User user= userRepository.findByEmailId(loginRequest.getEmail());
		if(user==null) {
			return "user with the given Id not found";
		}
		else if(user!= null && !user.getPassword().equals(loginRequest.getPassword())) {
			return "username and password doesnt match";
		}
		else {
			user.setLoggedIn(true);
			userRepository.save(user);
			return "successfully logged in";
		}
	}

	public String logout(String emailId) {
		if(userRepository.existsByEmailId(emailId)){
			User user= userRepository.findByEmailId(emailId);
			if(user.isLoggedIn()) {
				user.setLoggedIn(false);
				userRepository.save(user);
				return "User "+ emailId +" successfully logged out from the system";
			}
			else {
				return "User is not Logged in currently !";
			}
		}
		else {
			return "User with the given Id Not registered in the System !";
		}
	}

	public String forgotPassword(LoginRequest loginRequest) {
		if(userRepository.existsByEmailId(loginRequest.getEmail())){
			User user= userRepository.findByEmailId(loginRequest.getEmail());
				user.setLoggedIn(false);
				user.setPassword(loginRequest.getPassword());
				userRepository.save(user);
				return "New Password updated successfully!";
		}
		else {
			return "User with the given id Not registered in the System !";
		}
	}
	
	public String resetPassword(ResetPasswordRequest resetPasswordRequest) {
		if(userRepository.existsByEmailId(resetPasswordRequest.getEmail())){
			User user= userRepository.findByEmailId(resetPasswordRequest.getEmail());
				
			if(resetPasswordRequest.getOldPassword().equals(user.getPassword())) {
				user.setPassword(resetPasswordRequest.getNewPassword());
				userRepository.save(user);
				return "Password Reset success";
			} else {
				return "Given username and password doent match to reset password !";
			}
		}
		else {
			return "User with the given id Not registered in the System !";
		}
	}
	
}
