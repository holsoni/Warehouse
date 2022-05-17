package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "person")
@Builder
public class Person {

    @Id
    private Long id;

    private String name;
    private String dateOfBirth;
    private String telephone;
    private String email;


}
