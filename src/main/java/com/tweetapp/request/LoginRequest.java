package com.tweetapp.request;

public class LoginRequest {
	
	String email;
	String password;
	
	
	public LoginRequest() {
	}
	
	public LoginRequest(String username, String password) {
		super();
		this.email = username;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
