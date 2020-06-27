package com.example.parking.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


	@Entity
	public class NonVipSlotRequest {

		@Id
		@GeneratedValue(strategy = GenerationType.TABLE)
		private int nonVipSlotRequestId;
		private int employeeId;
	    private LocalDate RequestDate;
	   
	    @Enumerated(value=EnumType.STRING)
		private Status status;
		public int getNonVipSlotRequestId() {
			return nonVipSlotRequestId;
		}
		public void setNonVipSlotRequestId(int nonVipSlotRequestId) {
			this.nonVipSlotRequestId = nonVipSlotRequestId;
		}
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public LocalDate getRequestDate() {
			return RequestDate;
		}
		public void setRequestDate(LocalDate requestDate) {
			RequestDate = requestDate;
		}
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}
		
	    
}