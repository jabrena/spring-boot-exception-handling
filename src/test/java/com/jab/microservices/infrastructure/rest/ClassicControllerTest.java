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
class ClassicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void given_classicController_when_call_endpoint_ok_then_ok() throws Exception {
        this.mockMvc.perform(get("/api/classic/ok"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void given_classicController_when_call_endpoint_ko_then_ko() throws Exception {
        this.mockMvc.perform(get("/api/classic/ko"))
                .andDo(print())
                .andExpect(status().isServiceUnavailable());
    }

    @Test
    public void given_classicController_when_call_endpoint_ko2_then_ko() throws Exception {
        this.mockMvc.perform(get("/api/classic/ko2"))
                .andDo(print())
                .andExpect(status().isServiceUnavailable());
    }

}