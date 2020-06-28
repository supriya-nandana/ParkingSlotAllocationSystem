package com.example.parking.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.dao.NonVipEmployeeDao;
import com.example.parking.dao.VipSlotReleaseDao;
import com.example.parking.dtos.EmployeeSlotRequestDto;
import com.example.parking.dtos.StatusResponseDto;
import com.example.parking.exceptions.NonVipEmployeeSlotRequestException;
import com.example.parking.models.NonVipSlotRequest;
import com.example.parking.models.Status;
import com.example.parking.service.NonVipEmployeeService;

@Service
public class NonVipEmployeeServiceImpl implements NonVipEmployeeService {

	@Autowired
	NonVipEmployeeDao nonVipEmployeeDao;

	@Autowired
	VipSlotReleaseDao vipSlotReleaseDao;
	public static int count=0; 
	
	@Override
	public void SaveEmployeeSlotRequest(EmployeeSlotRequestDto employeeSlotRequestDto, int employeeId) throws NonVipEmployeeSlotRequestException {
		NonVipSlotRequest nonVipSlotRequest = new NonVipSlotRequest();
	//	BeanUtils.copyProperties(employeeSlotRequestDto, nonVipSlotRequest);
		nonVipSlotRequest.setRequestDate(employeeSlotRequestDto.getRequestDate());
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		System.out.println(employeeSlotRequestDto.getRequestDate());
		System.out.println(tomorrow);
		if (employeeSlotRequestDto.getRequestDate().equals(tomorrow)) {
			nonVipSlotRequest.setStatus(Status.pending);
			nonVipSlotRequest.setEmployeeId(employeeId);
			nonVipEmployeeDao.save(nonVipSlotRequest);
		}
		
		else {
			throw new NonVipEmployeeSlotRequestException("You can able to book the slot for the next day only");
		}
	}

	@Override
	public StatusResponseDto updateStatus(int nonVipSlotRequestId) {
		StatusResponseDto statusres=new StatusResponseDto();
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		
		LocalDate date1 = vipSlotReleaseDao.getFromReleaseDate(nonVipSlotRequestId);
		LocalDate date2 = vipSlotReleaseDao.getToReleaseDate(nonVipSlotRequestId);
		long numOfDays = ChronoUnit.DAYS.between(date1, date2);       
        List<LocalDate> listOfDates1 = Stream.iterate(date1, date -> date.plusDays(1))
                                   .limit(numOfDays)
                                    .collect(Collectors.toList());
      
		 for (Object obj : listOfDates1)
		 {
			 if(obj.equals(tomorrow)) {
				 NonVipSlotRequest nonvipreq = nonVipEmployeeDao.findBySlotRequestId(nonVipSlotRequestId);
				nonvipreq.setStatus(Status.accepted);
				nonVipEmployeeDao.save(nonvipreq);
				BeanUtils.copyProperties(nonvipreq, statusres);
				 }
			 
		 }
		 return statusres; 		
	}

}
