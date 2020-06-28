/**
 * 
 */
package com.example.parking.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.models.VipSlotRelease;

@Repository
public interface VipSlotReleaseDao extends CrudRepository<VipSlotRelease, Integer>{

	@Query(value="select v.slot_id from vip_slot v where v.employee_id=:employeeId",nativeQuery = true)
	int getSlotIdByEmployeeId(int employeeId);
	
	@Query(value="select release_from_date from vip_slot_release where vip_slot_release_id=:vipSlotReleaseId",nativeQuery=true)
	LocalDate getFromReleaseDate(int vipSlotReleaseId);
	
	@Query(value="select release_to_date from vip_slot_release where vip_slot_release_id=:vipSlotReleaseId",nativeQuery=true)
	LocalDate getToReleaseDate(int vipSlotReleaseId);
}
