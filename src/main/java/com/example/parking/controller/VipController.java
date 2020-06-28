package com.example.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.dtos.VipEmployeeReleaseDto;
import com.example.parking.service.VipEmployeeService;

@RestController
public class VipController {

	@Autowired
	VipEmployeeService vipService;
	
	@PostMapping("/slots/{employeeId}/slotrelease")
	public String vipSlotRealease(@RequestBody VipEmployeeReleaseDto vipDto,@PathVariable("employeeId") int  employeeId)
	{
		 return vipService.vipSlotRealease(vipDto,employeeId);		
	}	

}
