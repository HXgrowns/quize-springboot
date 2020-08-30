package com.thoughtworks.rslist.service;

import com.thoughtworks.rslist.domain.Order;
import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.exception.InvalidIndexException;
import com.thoughtworks.rslist.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> findList() {
        return orderRepository.findAll();
    }

    public void save(Order order) {
        orderRepository.save(order.build());
    }

    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    public void update(String name) {
        OrderEntity order = orderRepository.findByName(name).orElseThrow(() -> new InvalidIndexException("not found order"));
        order.setCount(order.getCount() + 1);
        orderRepository.save(order);
    }
}
