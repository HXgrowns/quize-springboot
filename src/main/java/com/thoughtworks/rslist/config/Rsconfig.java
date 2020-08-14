package com.thoughtworks.rslist.config;

import com.thoughtworks.rslist.repository.ProductRepository;
import com.thoughtworks.rslist.service.RsEventService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Rsconfig {
    @Bean
    public RsEventService rsEventService(ProductRepository productRepository) {
        return new RsEventService(productRepository);
    }

}
