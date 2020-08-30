package com.thoughtworks.rslist.domain;

import com.thoughtworks.rslist.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private String name;
    private Double price;
    private int count;
    private String unit;

    public OrderEntity build() {
        return OrderEntity.builder()
                .name(this.name)
                .price(this.price)
                .count(this.count)
                .unit(this.unit)
                .build();
    }
}
