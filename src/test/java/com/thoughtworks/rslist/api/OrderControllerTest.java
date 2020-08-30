package com.thoughtworks.rslist.api;

import jdk.net.SocketFlow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.JsonPath;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetOrderList() throws Exception {
        mockMvc.perform(get("/order/list"))
                .andExpect(status().isOk());
    }
}