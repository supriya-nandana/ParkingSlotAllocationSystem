package com.example.parking.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


	@Entity
	public class VipSlotRelease {

		@Id
		@GeneratedValue(strategy = GenerationType.TABLE)
		private int vipSlotReleaseId;
		private int slotId;
	    private LocalDate ReleaseFromDate;
	    private LocalDate ReleaseToDate;
		public int getVipSlotReleaseId() {
			return vipSlotReleaseId;
		}
		public void setVipSlotReleaseId(int vipSlotReleaseId) {
			this.vipSlotReleaseId = vipSlotReleaseId;
		}
		public int getSlotId() {
			return slotId;
		}
		public void setSlotId(int slotId) {
			this.slotId = slotId;
		}
		public LocalDate getReleaseFromDate() {
			return ReleaseFromDate;
		}
		public void setReleaseFromDate(LocalDate releaseFromDate) {
			ReleaseFromDate = releaseFromDate;
		}
		public LocalDate getReleaseToDate() {
			return ReleaseToDate;
		}
		public void setReleaseToDate(LocalDate releaseToDate) {
			ReleaseToDate = releaseToDate;
		}
	    
}
