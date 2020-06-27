package com.example.parking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VipSlot {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int slotId;
	private String slotNumber;
	private int employeeId;
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public String getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
