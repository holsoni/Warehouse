package com.example.demo.repository;

import com.example.demo.entities.Accounting;
import com.example.demo.entities.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepo extends JpaRepository<Deal, Long > {
    Deal getById(Long id);
}
