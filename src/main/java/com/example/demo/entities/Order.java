package com.example.demo.entities;
/*
    @author:    Sasha
    @project:    Warehouse 
    @class:    Delivery 
    @version:    1.0.0 
    @since:    11.05.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
@Builder
public class Order {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name="producer_id")
    private Producer producer;
    @ManyToMany
    @JoinTable(name="goods_to_order",
            joinColumns=@JoinColumn(name="order_id"),
            inverseJoinColumns=@JoinColumn(name="goods_id"))
    private Set<Goods> orderList;
    private double sum;
    @ManyToOne
    @JoinColumn(name="person_id")
    private Person contacts;


}
