package com.jab.microservices.infrastructure.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OtherCasesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void given_other_endpoint_resource1_when_call_then_ko() throws Exception {
        this.mockMvc.perform(get("/api/other/resource1"))
                .andDo(print())
                .andExpect(status().isServiceUnavailable());
    }

    @Test
    public void given_other_endpoint_resource2_when_call_then_ko() throws Exception {
        this.mockMvc.perform(get("/api/other/resource2"))
                .andDo(print())
                .andExpect(status().isServiceUnavailable());
    }

}