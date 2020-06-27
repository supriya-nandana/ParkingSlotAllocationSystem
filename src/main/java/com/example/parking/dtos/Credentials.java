package com.example.parking.dtos;

import javax.validation.constraints.NotEmpty;

public class Credentials {

	@NotEmpty(message="password should not be empty")
	private String password;
	@NotEmpty(message="mailId should not be empty")
	private String mailId;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
}
