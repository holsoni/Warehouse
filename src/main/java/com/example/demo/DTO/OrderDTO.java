package com.example.demo.DTO;

import com.example.demo.entities.Goods;
import com.example.demo.entities.Person;
import com.example.demo.entities.Producer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDTO {

    private Long id;

    private Long producer_id;
    private String producer;
    private String producer_country;

    private List<Long> goodsId;
   // private double sumOfOrder;

    private Long responsiblePersonId;
    private String responsiblePersonName;
    private String responsiblePersonTelephone;

}
