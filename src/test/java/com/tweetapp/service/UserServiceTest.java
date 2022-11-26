package com.tweetapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tweetapp.entity.User;
import com.tweetapp.repository.UserRepository;
import com.tweetapp.request.LoginRequest;
import com.tweetapp.request.ResetPasswordRequest;
import com.tweetapp.request.UserRequest;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Test
	void testAddUser() {
		UserRequest user=new UserRequest("sham","sham","sham");
		assertNotNull(userService.addUser(user));
		assertEquals("User Registered Successfully!", userService.addUser(user));
	}
	
	@Test
	void testLogout() {
		User user=new User();
		user.setEmailId("sham@gmail.com");
		user.setPassword("sham");
		user.setLoggedIn(true);
		when(userRepository.existsByEmailId("sham")).thenReturn(true);
		when(userRepository.findByEmailId("sham")).thenReturn(user);
		assertNotNull(userService.logout("sham"));
	}
	
	@Test
	void testforgotPassword() {
		LoginRequest loginRequest=new LoginRequest();
		loginRequest.setEmail("sham");
		User user=new User();
		user.setEmailId("sham");
		user.setPassword("sham");
		user.setLoggedIn(true);
		when(userRepository.existsByEmailId("sham")).thenReturn(true);
		when(userRepository.findByEmailId("sham")).thenReturn(user);
		assertNotNull(userService.forgotPassword(loginRequest));
		assertEquals("New Password updatede successfully!", userService.forgotPassword(loginRequest));
	}
	
	@Test
	void testResetPassword() {
		ResetPasswordRequest resetPasswordRequest=new 
				ResetPasswordRequest("sham", "sham", "sham");
		User user=new User();
		user.setEmailId("sham");
		user.setPassword("sham");
		user.setLoggedIn(true);
		when(userRepository.existsByEmailId("sham")).thenReturn(true);
		when(userRepository.findByEmailId("sham")).thenReturn(user);
		assertNotNull(userService.resetPassword(resetPasswordRequest));
		assertEquals("Password Reset success", userService.resetPassword(resetPasswordRequest));
	}
	
	@Test
	void testLogin() {
		LoginRequest loginRequest= new LoginRequest();
		loginRequest.setEmail("sham");
		loginRequest.setPassword("sham");
		User user=new User();
		user.setEmailId("sham");
		user.setPassword("sham");
		user.setLoggedIn(false);
		when(userRepository.findByEmailId("sham")).thenReturn(user);
		assertNotNull(userService.login(loginRequest));
		assertEquals("successfully logged in", userService.login(loginRequest));
	}
	
	
}
