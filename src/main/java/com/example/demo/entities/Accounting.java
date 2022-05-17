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
@Entity(name = "accounting")
@Builder
public class Accounting {

    @Id
    private String id;

    private String date;
    @ManyToOne
    @JoinColumn(name="goods_id")
    private Goods goods;
    private boolean receiving;
    private boolean givingOut;
    private String conclusion;


}
