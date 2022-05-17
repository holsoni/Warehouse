package com.example.demo.repository;

import com.example.demo.entities.Accounting;
import com.example.demo.entities.Deal;
import com.example.demo.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Long > {
    Delivery getById(Long id);
}
