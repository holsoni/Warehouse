package com.example.demo.service;

import com.example.demo.entities.Accounting;
import com.example.demo.repository.AccountingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountingService {

    private final AccountingRepo repo;

    public Page<Accounting> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Accounting getById(Long id) {
        return repo.getById(id);
    }

    public Accounting create(Accounting accounting){
       return repo.save(accounting);
    }

    public Accounting update(Accounting accounting){
        Long id = accounting.getId();
        repo.deleteById(id);
        repo.save(accounting);
        accounting.setId(id);
        return accounting;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Accounting " + id + " deleted succesfully";
    }

}
