package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderUpdateRequest {

    private Long id;

    private List<Long> goodsId;
    private double sumOfOrder;

    private Long responsiblePersonId;
    private String responsiblePersonName;
    private String responsiblePersonTelephone;
}
