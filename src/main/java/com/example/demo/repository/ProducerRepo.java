package com.example.demo.repository;

import com.example.demo.entities.Accounting;
import com.example.demo.entities.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepo extends JpaRepository<Producer, Long > {
}
