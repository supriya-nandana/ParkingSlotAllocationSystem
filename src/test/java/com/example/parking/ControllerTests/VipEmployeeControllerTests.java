package com.example.parking.ControllerTests;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.parking.controller.VipController;
import com.example.parking.dtos.VipEmployeeReleaseDto;
import com.example.parking.service.VipEmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
	public class VipEmployeeControllerTests {


    ObjectMapper objectMapper;
    
    
    @Mock
    VipEmployeeService vipService;
    
    @InjectMocks
    VipController vipController;
    
    MockMvc mockMvc;
    
    VipEmployeeReleaseDto vipDto;
    
    @BeforeEach
    public void setUp()
    {
        objectMapper=new ObjectMapper();
        mockMvc=MockMvcBuilders.standaloneSetup(vipController).build();
             
        vipDto=new VipEmployeeReleaseDto();
        LocalDate date=LocalDate.of(2020, 06, 27);
        LocalDate date1=LocalDate.of(2020, 06, 30);
        
        vipDto.setReleaseFromDate(date);
        vipDto.setReleaseToDate(date1);
        
        
        
    }
    @Test
    public void vipSlotReleaseTest() throws JsonProcessingException, Exception
    {
        when(vipService.vipSlotRealease(vipDto, 1));
             
        mockMvc.perform(post("/slots/{employeeId}/slotrelease").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(vipDto)))
                .andExpect(status().isOk())
                .andReturn();
                
        verify(vipService).vipSlotRealease(vipDto, 1);
        
    }
    


}
 








