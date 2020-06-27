package com.example.parking.service;

import com.example.parking.exceptions.InvalidCredentialsException;

public interface EmployeeService {

	String authenticate(String mailId, String password) throws InvalidCredentialsException;

}
