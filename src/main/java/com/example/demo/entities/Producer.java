package com.example.demo.entities;

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
@Entity(name = "producer")
@Builder
public class Producer {

    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person head;
    private String country;
    private String address;
    private String telephone;
    private double rating;


}
