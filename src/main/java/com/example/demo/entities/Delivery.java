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
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "delivery")
@Builder
public class Delivery {

    @Id
    private Long id;

    private String nameOfCompany;
    private String address;
    @ManyToMany
    @JoinTable(name="goods_for_delivery",
            joinColumns=@JoinColumn(name="delivery_id"),
            inverseJoinColumns=@JoinColumn(name="goods_id"))
    private Set<Goods> orderList;
    private double sum;
    @ManyToOne
    @JoinColumn(name="person_id")
    private Person contacts;


}
