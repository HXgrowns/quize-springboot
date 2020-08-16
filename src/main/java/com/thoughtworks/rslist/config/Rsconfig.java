package com.thoughtworks.rslist.config;

import com.thoughtworks.rslist.repository.ProductRepository;
import com.thoughtworks.rslist.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Rsconfig {
    @Bean
    public ProductService rsEventService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }

}
