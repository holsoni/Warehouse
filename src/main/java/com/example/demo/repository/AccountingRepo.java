package com.example.demo.repository;

import com.example.demo.entities.Accounting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountingRepo extends JpaRepository<Accounting, Long > {
}
