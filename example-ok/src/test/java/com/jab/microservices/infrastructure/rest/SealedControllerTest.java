package com.jab.microservices.infrastructure.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SealedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void given_optional_endpoint_resource_when_call_with_parameter_1_then_ok() throws Exception {

        //Given
        var param = 1;

        //When
        //Then
        this.mockMvc.perform(get("/api/sealed/resource?id="+ param))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void given_optional_endpoint_resource_when_call_with_parameter_2_then_ko() throws Exception {

        //Given
        var param = 2;

        //When
        //Then
        this.mockMvc.perform(get("/api/sealed/resource?id="+ param))
                .andDo(print())
                .andExpect(status().isServiceUnavailable());
    }

    @Test
    public void given_optional_endpoint_resource_when_call_with_parameter_3_then_ko() throws Exception {

        //Given
        var param = 3;

        //When
        //Then
        this.mockMvc.perform(get("/api/sealed/resource?id="+ param))
                .andDo(print())
                .andExpect(status().isServiceUnavailable());
    }
}