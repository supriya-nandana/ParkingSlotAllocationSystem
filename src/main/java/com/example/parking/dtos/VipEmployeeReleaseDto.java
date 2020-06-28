package com.example.parking.dtos;

import java.time.LocalDate;

public class VipEmployeeReleaseDto {
	 private LocalDate ReleaseFromDate;
	    private LocalDate ReleaseToDate;
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
