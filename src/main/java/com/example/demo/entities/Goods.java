package com.example.demo.entities;

/*
    @author:    Sasha
    @project:    Warehouse 
    @class:    Goods 
    @version:    1.0.0 
    @since:    11.05.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "goods")
@Builder
public class Goods {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name="producer_id")
    private Producer producer;
    private String name;
    private String unitsOfMeasurement;
    private double num;
    private double purchasePricePerUnit;
    private double sellingPricePerUnit;


}
