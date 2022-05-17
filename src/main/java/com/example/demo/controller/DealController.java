package com.example.demo.controller;

import com.example.demo.entities.Deal;
import com.example.demo.service.DealService;
import com.example.demo.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deal")
@RequiredArgsConstructor
public class DealController {

    private final DealService service;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Deal>> getAll(@RequestParam(required = false, defaultValue = "10") int size,
                                                   @RequestParam(required = false,defaultValue = "1") int page){

        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Deal getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Deal create(@RequestBody Deal deal) {
        return service.create(deal);
    }

    @PutMapping("/update")
    public Deal update( @RequestBody Deal deal) {
        return service.update(deal);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
