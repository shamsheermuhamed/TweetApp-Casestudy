package com.tweetapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserAlreadyExistsException extends RuntimeException {
		
		@ExceptionHandler
		public ResponseEntity<Object> exception(UserAlreadyExistsException ex)
		{
			return new ResponseEntity<>("User Already Exists",HttpStatus.NOT_ACCEPTABLE);
		}

}