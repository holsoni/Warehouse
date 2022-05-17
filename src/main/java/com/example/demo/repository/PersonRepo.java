package com.example.demo.repository;

import com.example.demo.entities.Accounting;
import com.example.demo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long > {
}
