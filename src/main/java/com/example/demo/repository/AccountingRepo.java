package com.example.demo.repository;

import com.example.demo.entities.Accounting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRepo extends JpaRepository<Accounting, Long > {

    Accounting getById(Long id);
}
