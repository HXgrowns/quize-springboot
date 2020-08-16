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
    void shouldAddProductSuccess() throws Exception {

        String product = "{\"name\":\"威化饼\",\"price\":17.8,\"unit\":\"袋\",\"img\":\"https://img.alicdn.com/bao/uploaded/i4/725677994/O1CN01en7iXF28vIlV6FNq2_!!725677994.jpg_160x160q90.jpg\"}";

        mockMvc.perform(post("/product")
                .contentType("application/json;charset=UTF-8")
                .content(product))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldFindAll() throws Exception {
        String products = mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(products);
    }

    @Test
    void shouldDeleteProductSuccess() throws Exception {
        mockMvc.perform(delete("/product/15"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldAddProductListSuccess() throws Exception {
        String products = "[{\"name\":\"威化饼\",\"price\":17.8,\"unit\":\"袋\",\"img\":\"https://img.alicdn.com/bao/uploaded/i4/725677994/O1CN01en7iXF28vIlV6FNq2_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"纯牛奶\",\"price\":59.5,\"unit\":\"箱\",\"img\":\"https://img.alicdn.com/bao/uploaded/i2/725677994/O1CN01D9Tfqv28vIj7kkIAZ_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"威化饼\",\"price\":17.8,\"unit\":\"袋\",\"img\":\"https://img.alicdn.com/bao/uploaded/i4/725677994/O1CN01en7iXF28vIlV6FNq2_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"纯牛奶\",\"price\":59.5,\"unit\":\"箱\",\"img\":\"https://img.alicdn.com/bao/uploaded/i2/725677994/O1CN01D9Tfqv28vIj7kkIAZ_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"威化饼\",\"price\":17.8,\"unit\":\"袋\",\"img\":\"https://img.alicdn.com/bao/uploaded/i4/725677994/O1CN01en7iXF28vIlV6FNq2_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"纯牛奶\",\"price\":59.5,\"unit\":\"箱\",\"img\":\"https://img.alicdn.com/bao/uploaded/i2/725677994/O1CN01D9Tfqv28vIj7kkIAZ_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"威化饼\",\"price\":17.8,\"unit\":\"袋\",\"img\":\"https://img.alicdn.com/bao/uploaded/i4/725677994/O1CN01en7iXF28vIlV6FNq2_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"纯牛奶\",\"price\":59.5,\"unit\":\"箱\",\"img\":\"https://img.alicdn.com/bao/uploaded/i2/725677994/O1CN01D9Tfqv28vIj7kkIAZ_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"威化饼\",\"price\":17.8,\"unit\":\"袋\",\"img\":\"https://img.alicdn.com/bao/uploaded/i4/725677994/O1CN01en7iXF28vIlV6FNq2_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"纯牛奶\",\"price\":59.5,\"unit\":\"箱\",\"img\":\"https://img.alicdn.com/bao/uploaded/i2/725677994/O1CN01D9Tfqv28vIj7kkIAZ_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"威化饼\",\"price\":17.8,\"unit\":\"袋\",\"img\":\"https://img.alicdn.com/bao/uploaded/i4/725677994/O1CN01en7iXF28vIlV6FNq2_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"纯牛奶\",\"price\":59.5,\"unit\":\"箱\",\"img\":\"https://img.alicdn.com/bao/uploaded/i2/725677994/O1CN01D9Tfqv28vIj7kkIAZ_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"威化饼\",\"price\":17.8,\"unit\":\"袋\",\"img\":\"https://img.alicdn.com/bao/uploaded/i4/725677994/O1CN01en7iXF28vIlV6FNq2_!!725677994.jpg_160x160q90.jpg\"},{\"name\":\"纯牛奶\",\"price\":59.5,\"unit\":\"箱\",\"img\":\"https://img.alicdn.com/bao/uploaded/i2/725677994/O1CN01D9Tfqv28vIj7kkIAZ_!!725677994.jpg_160x160q90.jpg\"}]";

        mockMvc.perform(post("/product/addList")
                .contentType("application/json;charset=UTF-8")
                .content(products))
                .andExpect(status().isCreated());
    }
}
