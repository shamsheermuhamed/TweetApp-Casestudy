package com.tweetapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UserNotExist extends RuntimeException {
		
		@ExceptionHandler
		public ResponseEntity<Object> exception(UserNotExist ex)
		{
			return new ResponseEntity<>("User Not Registered in System. Please Register !",HttpStatus.NOT_ACCEPTABLE);
		}

}