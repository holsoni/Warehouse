package com.example.demo.service;

import com.example.demo.entities.Delivery;
import com.example.demo.repository.DeliveryRepo;
import com.example.demo.repository.DeliveryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepo repo;

    public Page<Delivery> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Delivery getById(Long id) {
        return repo.getById(id);
    }

    public Delivery create(Delivery delivery){
       return repo.save(delivery);
    }

    public Delivery update(Delivery delivery){
        Long id = delivery.getId();
        repo.deleteById(id);
        repo.save(delivery);
        delivery.setId(id);
        return delivery;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Delivery " + id + " deleted succesfully";
    }

}
