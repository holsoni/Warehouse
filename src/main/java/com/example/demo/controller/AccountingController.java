package com.example.demo.controller;

import com.example.demo.entities.Accounting;
import com.example.demo.service.AccountingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounting")
@RequiredArgsConstructor
public class AccountingController {

    private final AccountingService service;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Accounting>> getAll(@RequestParam(required = false, defaultValue = "10") int size,
                                                   @RequestParam(required = false,defaultValue = "1") int page){

        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Accounting getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Accounting create(@RequestBody Accounting accounting) {
        return service.create(accounting);
    }

    @PutMapping("/update")
    public Accounting update( @RequestBody Accounting accounting) {
        return service.update(accounting);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
