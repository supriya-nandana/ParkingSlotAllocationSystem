package com.example.parking.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.parking.models.NonVipSlotRequest;

public interface NonVipEmployeeDao extends CrudRepository<NonVipSlotRequest, Integer> {

	@Query(value="select * from non_vip_slot_request nvip where non_vip_slot_request_id=:nonVipSlotRequestId",nativeQuery = true)
	NonVipSlotRequest findBySlotRequestId(int nonVipSlotRequestId);

	
}
