package com.example.demo.controller;

import com.example.demo.DTO.OrderCreateRequest;
import com.example.demo.DTO.OrderDTO;
import com.example.demo.DTO.OrderUpdateRequest;
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
    public ResponseEntity<Page<OrderDTO>> getAll(@RequestParam(required = false, defaultValue = "10") int size,
                                                   @RequestParam(required = false,defaultValue = "1") int page){

        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public OrderDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public OrderDTO create(@RequestBody OrderCreateRequest order) {
        return service.create(order);
    }

    @PutMapping("/update")
    public OrderDTO update( @RequestBody OrderUpdateRequest order) {
        return service.update(order);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
