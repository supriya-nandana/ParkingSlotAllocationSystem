package com.example.parking.service;

import com.example.parking.dtos.EmployeeSlotRequestDto;
import com.example.parking.dtos.StatusResponseDto;
import com.example.parking.exceptions.NonVipEmployeeSlotRequestException;

public interface NonVipEmployeeService {
	
	void SaveEmployeeSlotRequest(EmployeeSlotRequestDto employeeSlotRequestDto, int employeeId) throws NonVipEmployeeSlotRequestException;

	StatusResponseDto updateStatus(int nonVipSlotRequestId);

}
