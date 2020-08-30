package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
