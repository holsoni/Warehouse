package com.example.demo.controller;

import com.example.demo.entities.Order;
import com.example.demo.service.OrderService;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Order>> getAll(@RequestParam(required = false, defaultValue = "10") int size,
                                                   @RequestParam(required = false,defaultValue = "1") int page){

        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Order getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    @PutMapping("/update")
    public Order update( @RequestBody Order order) {
        return service.update(order);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
