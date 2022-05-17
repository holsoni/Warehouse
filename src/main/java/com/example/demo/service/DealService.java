package com.example.demo.service;

import com.example.demo.entities.Deal;
import com.example.demo.repository.DealRepo;
import com.example.demo.repository.DealRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DealService {

    private final DealRepo repo;

    public Page<Deal> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Deal getById(Long id) {
        return repo.getById(id);
    }

    public Deal create(Deal deal){
       return repo.save(deal);
    }

    public Deal update(Deal deal){
        Long id = deal.getId();
        repo.deleteById(id);
        repo.save(deal);
        deal.setId(id);
        return deal;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Deal " + id + " deleted succesfully";
    }

}
