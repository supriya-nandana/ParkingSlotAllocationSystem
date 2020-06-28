package com.example.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.dtos.EmployeeSlotRequestDto;
import com.example.parking.exceptions.NonVipEmployeeSlotRequestException;
import com.example.parking.service.NonVipEmployeeService;

@RestController
public class NonVipController {

	@Autowired
	NonVipEmployeeService nonVipEmployeeSerice;
	
	@PostMapping("/employee/{employeeId}/slotRequestDate")
	public String slotBook(@RequestBody EmployeeSlotRequestDto employeeSlotRequestDto,@PathVariable("employeeId") int employeeId) throws NonVipEmployeeSlotRequestException {
		nonVipEmployeeSerice.SaveEmployeeSlotRequest(employeeSlotRequestDto,employeeId);
		 return "employee succussfully raise the request";
	}
	
	
	/*
	@PutMapping("slots/{nonVipSlotRequestId}/status") 
	 public StatusResponseDto statusUpdate(@PathVariable("nonVipSlotRequestId")int nonVipSlotRequestId)
	 {
		 return nonVipEmployeeSerice.updateStatus(nonVipSlotRequestId);
     }
	 */
	
	@ExceptionHandler(NonVipEmployeeSlotRequestException.class)
	public ResponseEntity<String> exceptionHandler(NonVipEmployeeSlotRequestException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
