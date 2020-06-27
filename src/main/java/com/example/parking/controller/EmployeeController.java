package com.example.parking.controller;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.dtos.Credentials;
import com.example.parking.exceptions.InvalidCredentialsException;
import com.example.parking.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	
	 @PostMapping("/login")
    public String login(@Valid @RequestBody Credentials credentials) throws InvalidCredentialsException {
       // logger.info("authenticating the user");
    	return employeeService.authenticate(credentials.getMailId(), credentials.getPassword());
       
    }
	 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException ex) {
	        Map<String,String> errorMessage = new HashMap<String,String>();
	                ex.getBindingResult().getFieldErrors().forEach(error -> errorMessage.put("message",error.getDefaultMessage()));
	       return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	   
	    }

		
		@ExceptionHandler(InvalidCredentialsException.class)
		public ResponseEntity<String> exceptionHandler(InvalidCredentialsException exception){
			return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
	
}
