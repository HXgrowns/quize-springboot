package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.domain.Order;
import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "list")
    public ResponseEntity<List<OrderEntity>> getOrderList() {
        return ResponseEntity.ok(orderService.findList());
    }

    @PostMapping(value = "save")
    public ResponseEntity save(@RequestBody Order order) {
        orderService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "update")
    public ResponseEntity update(@RequestParam String name) {
        orderService.update(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        orderService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
