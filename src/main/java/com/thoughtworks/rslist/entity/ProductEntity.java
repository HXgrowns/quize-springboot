package com.thoughtworks.rslist.entity;

import lombok.*;

import javax.persistence.*;

import com.thoughtworks.rslist.response.ProductResponse;

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
}
