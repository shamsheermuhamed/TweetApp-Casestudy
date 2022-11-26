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
			return new ResponseEntity<>("Please Login to the System!",HttpStatus.NOT_FOUND);
		}

}