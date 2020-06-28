package com.example.parking.ControllerTests;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.parking.controller.EmployeeController;
import com.example.parking.dtos.Credentials;
import com.example.parking.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTests {

		
		ObjectMapper objectMapper;
			
			
			@Mock
            EmployeeService employeeService;
			
			@InjectMocks
			EmployeeController employeeController;
			
			MockMvc mockMvc;

			
			
			Credentials credentials;
			
			
			@BeforeEach
			public void setUp()
			{
				objectMapper=new ObjectMapper();
				mockMvc=MockMvcBuilders.standaloneSetup(employeeController).build();
				credentials=new Credentials();
				credentials.setPassword("1234");
				credentials.setMailId("mansa@gmail.com");
				
			}
			
			@Test
			public void loginTest() throws Exception
			{
				//given
				when(employeeService.authenticate("manasa@gmail.com", "1234")).thenReturn("success");
				
				//when and then
				mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(objectMapper.writeValueAsString(credentials)))
				        .andExpect(status().isOk())
				        .andExpect(jsonPath("$", Matchers.is("success")));      
				verify(employeeService).authenticate("manasa@gmail.com", "1234");
			}
			
			

}
