package com.example.demo.repository;

import com.example.demo.entities.Accounting;
import com.example.demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long > {

    Order getById(Long id);
}
