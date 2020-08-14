package com.thoughtworks.rslist.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double price;
    private String imgSrc;
    private int count;
    private String unit;

    public ProductEntity build() {
        return ProductEntity.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .imgSrc(this.imgSrc)
                .count(this.count)
                .unit(this.unit)
                .build();
    }
}
