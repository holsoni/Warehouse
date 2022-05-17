package com.example.demo.repository;

import com.example.demo.entities.Accounting;
import com.example.demo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long > {

    Person getById(Long id);
}
