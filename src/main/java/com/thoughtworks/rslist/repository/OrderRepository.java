package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.domain.Order;
import com.thoughtworks.rslist.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    Optional<OrderEntity> findByName(String name);
}
