package com.example.parking.dtos;

import java.time.LocalDate;

public class EmployeeSlotRequestDto {
	
    private LocalDate RequestDate;
    //private String message;
    
	
	public LocalDate getRequestDate() {
		return RequestDate;
	}
	public void setRequestDate(LocalDate requestDate) {
		RequestDate = requestDate;
	}
}
