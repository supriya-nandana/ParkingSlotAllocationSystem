package com.example.parking.service;

import com.example.parking.dtos.VipEmployeeReleaseDto;

public interface VipEmployeeService {

	String vipSlotRealease(VipEmployeeReleaseDto vipDto, int employeeId);

}
