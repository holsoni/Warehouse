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
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "deal")
@Builder
public class Deal {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name="producer_id")
    private Producer producer;
    private double sumOfDeal;
    private Date dateOfDeal;
    private int dealDurabilityInMonth;

}
