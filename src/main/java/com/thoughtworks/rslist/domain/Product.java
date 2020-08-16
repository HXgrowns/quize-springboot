package com.thoughtworks.rslist.domain;

import com.thoughtworks.rslist.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Integer id;

    private String name;
    private Double price;
    private String img;
    private String unit;

    public Product(String name, Double price, String img, String unit) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.unit = unit;
    }
    public ProductEntity build() {
        return ProductEntity.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .img(this.img)
                .unit(this.unit)
                .build();
    }
}
