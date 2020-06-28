package com.example.parking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.models.VipSlot;
import com.example.parking.models.VipSlotRelease;

@Repository
public interface VipEmployeeDao extends CrudRepository<VipSlot, Integer> {

	void save(VipSlotRelease vipSlotRelease);

	
}
