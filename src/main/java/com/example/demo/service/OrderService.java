package com.example.demo.service;

import com.example.demo.entities.Order;
import com.example.demo.repository.OrderRepo;
import com.example.demo.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo repo;

    public Page<Order> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Order getById(Long id) {
        return repo.getById(id);
    }

    public Order create(Order order){
       return repo.save(order);
    }

    public Order update(Order order){
        Long id = order.getId();
        repo.deleteById(id);
        repo.save(order);
        order.setId(id);
        return order;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Order " + id + " deleted succesfully";
    }

}
