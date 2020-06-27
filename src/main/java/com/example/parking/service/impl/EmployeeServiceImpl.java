package com.example.parking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.dao.EmployeeDao;
import com.example.parking.exceptions.InvalidCredentialsException;
import com.example.parking.models.Employee;
import com.example.parking.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public String authenticate(String mailId, String password) throws InvalidCredentialsException {
		
		if((employeeDao.findTotalExperienceByMailId((mailId))>=10||(employeeDao.findcurrentCompExperienceByMailId(mailId))>=5)){
			Employee employee=employeeDao.findByMailIdAndPassword(mailId, password);
			if(employee!=null)
			return "Vip Employee Login Successfully";
			throw new InvalidCredentialsException("invalid credentials !! please try again with valid credentials"); 
	
		}
		else {
			Employee employee=employeeDao.findByMailIdAndPassword(mailId, password);
			if(employee!=null)
			return "Employee Login Successfully";
			throw new InvalidCredentialsException("invalid credentials !! please try again with valid credentials"); 
	
		}
		
		
	}

}
