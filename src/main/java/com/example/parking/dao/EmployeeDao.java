package com.example.parking.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.models.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	Employee findByMailIdAndPassword(String mailId, String password);

	@Query(value="select total_experience from employee e where e.mail_id=:mailId ",nativeQuery = true)
	int findTotalExperienceByMailId(String mailId);

	@Query(value="select current_comp_experience from employee e where e.mail_id=:mailId ",nativeQuery = true)
	int findcurrentCompExperienceByMailId(String mailId);

	
}
