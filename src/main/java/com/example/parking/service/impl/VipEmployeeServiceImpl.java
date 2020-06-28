package com.example.parking.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.dao.VipEmployeeDao;
import com.example.parking.dao.VipSlotReleaseDao;
import com.example.parking.dtos.VipEmployeeReleaseDto;
import com.example.parking.models.VipSlotRelease;
import com.example.parking.service.VipEmployeeService;


@Service
public class VipEmployeeServiceImpl implements VipEmployeeService {

	@Autowired
	VipSlotReleaseDao slotDao;
	
	@Autowired
	VipEmployeeDao vipDao;

	@Override
	public String vipSlotRealease(VipEmployeeReleaseDto vipDto, int employeeId) {
		VipSlotRelease vipSlotRelease=new VipSlotRelease();
		BeanUtils.copyProperties(vipDto, vipSlotRelease);
	    vipSlotRelease.setSlotId(slotDao.getSlotIdByEmployeeId(employeeId));
	    vipDao.save(vipSlotRelease);
	    return "slot released sucessfully";
	    
	}
	
	
}
