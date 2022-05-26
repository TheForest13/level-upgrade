package com.theforest.webflux.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "customer", schema = "public")
@Data
public class Customer {
    @Id
    @Column(value = "id")
    private Integer id;
    @Column(value = "name")
    private String name;
}