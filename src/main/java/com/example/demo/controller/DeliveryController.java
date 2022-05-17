package com.example.demo.controller;

import com.example.demo.entities.Delivery;
import com.example.demo.service.DeliveryService;
import com.example.demo.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService service;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Delivery>> getAll(@RequestParam(required = false, defaultValue = "10") int size,
                                                   @RequestParam(required = false,defaultValue = "1") int page){

        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Delivery getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Delivery create(@RequestBody Delivery delivery) {
        return service.create(delivery);
    }

    @PutMapping("/update")
    public Delivery update( @RequestBody Delivery delivery) {
        return service.update(delivery);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
