package com.example.demo.repository;

import com.example.demo.entities.Accounting;
import com.example.demo.entities.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepo extends JpaRepository<Goods, Long > {
    Goods getById(Long id);
}
