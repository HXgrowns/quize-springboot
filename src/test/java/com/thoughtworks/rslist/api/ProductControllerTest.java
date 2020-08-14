package com.thoughtworks.rslist.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.rslist.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldAddEventSuccess() throws Exception {
        String imgSrc = "https://image.baidu.com/search";
        Product product = new Product("kele1", 1.0, imgSrc, 0, "ping");
        ObjectMapper objectMapper = new ObjectMapper();
        String rsEventString = objectMapper.writeValueAsString(product);

        mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(rsEventString))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldFindById() throws Exception {
        mockMvc.perform(get("/rs/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.eventName", is("third event")))
                .andExpect(jsonPath("$.voteNum", is(14)))
                .andExpect(jsonPath("$.keyword", is("three")));

        mockMvc.perform(get("/rs/-1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("rsEvent is not exists")));
    }

    @Test
    public void shouldFindAllByPage() throws Exception {
        String rsEventList = mockMvc.perform(get("/products")
                .param("size", "10")
                .param("page", "0"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(rsEventList);
    }

    @Test
    void shouldUpdateRsEvent() throws Exception {
        String imgSrc = "https://image.baidu.com/search/detail?ct=503316480&z=0&tn=baiduimagedetail&ipn=d&word=%E5%8F%AF%E4%B9%90&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&hd=undefined&latest=undefined&copyright=undefined&cs=3577027695,1137157466&os=2186992339,3321455270&simid=3295121143,231832716&pn=5&rn=1&di=54230&ln=1440&fr=&fmq=1597392933152_R&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fs10.stb001.cn%2Fftp_product_img%2Fcn1100121026P00_1_xnl.jpg%3Ft%3D20170117&rpstart=0&rpnum=0&adpicid=0&force=undefined";
        Product product = new Product("可乐1", 1.0, imgSrc, 0, "瓶");
        ObjectMapper objectMapper = new ObjectMapper();
        String rsEventString = objectMapper.writeValueAsString(product);
        mockMvc.perform(patch("/rs/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(rsEventString))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldVoteRsEvent() throws Exception {
        mockMvc.perform(post("/rs/vote/-1")
                .param("userId", "3")
                .param("voteNum", "2"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("reEvent is not exists")));

        mockMvc.perform(post("/rs/vote/3")
                .param("userId", "-1")
                .param("voteNum", "2"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("user is not exists")));

        mockMvc.perform(post("/rs/vote/3")
                .param("userId", "3")
                .param("voteNum", "20"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("user total voteNum < voteNum")));

        mockMvc.perform(post("/rs/vote/2")
                .param("userId", "2")
                .param("voteNum", "2"))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldDeleteRsEvent() throws Exception {
        mockMvc.perform(delete("/rs/10"))
                .andExpect(status().isOk());
    }
}
