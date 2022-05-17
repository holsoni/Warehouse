package com.example.demo.repository;

import com.example.demo.entities.Accounting;
import com.example.demo.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepo extends JpaRepository<Delivery, Long > {
}
