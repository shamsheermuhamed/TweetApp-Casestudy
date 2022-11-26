package com.tweetapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.entity.User;
import com.tweetapp.request.LoginRequest;
import com.tweetapp.request.ResetPasswordRequest;
import com.tweetapp.request.UserRequest;
import com.tweetapp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	String addUser(@RequestBody UserRequest userRequest) {
		if(userRequest.getEmailId()==null || userRequest.getEmailId().equals("")) {
			return "please enter valid emailid to proceed";
		}
		return userService.addUser(userRequest);
	}
	
	@PostMapping("/login")
	String login(@RequestBody LoginRequest loginRequest) {
		return userService.login(loginRequest);
	}
	
	@PostMapping("/forgotpassword")
	String forgotPassword(@RequestBody LoginRequest loginRequest) {
		return userService.forgotPassword(loginRequest);
	}
	
	@PostMapping("/resetpasword")
	String resetPasworod(@RequestBody ResetPasswordRequest resetPasswordRequest) {
		return userService.resetPassword(resetPasswordRequest);
	}
	
	@PostMapping("/logout/{emailId}")
	String logout(@PathVariable String emailId) {
		return userService.logout(emailId);
	}
	
}
