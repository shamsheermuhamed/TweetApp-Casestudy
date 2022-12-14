package com.tweetapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserNotLoggedInException extends RuntimeException {
		
		@ExceptionHandler
		public ResponseEntity<Object> exception(UserNotLoggedInException ex)
		{
			return new ResponseEntity<>("User is not LoggedIn. Please Login to view the details!",HttpStatus.NOT_FOUND);
		}

}