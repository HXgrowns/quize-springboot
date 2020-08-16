package com.thoughtworks.rslist.service;

import com.thoughtworks.rslist.domain.Product;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.exception.InvalidIndexException;
import com.thoughtworks.rslist.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void save(Product product) {
        ProductEntity productEntity = product.build();
        productRepository.save(productEntity);
    }

    public List<ProductEntity> findList() {
        return productRepository.findAll();
    }

    public void deleteById(Integer id) {
        if (!productRepository.findById(id).isPresent()) {
            throw new InvalidIndexException("product is not exists");
        }
        productRepository.deleteById(id);
    }

    public void saveAll(List<Product> products) {
        List<ProductEntity> productEntities = products.stream().map((product) -> product.build()).collect(Collectors.toList());
        productRepository.saveAll(productEntities);
    }
}
