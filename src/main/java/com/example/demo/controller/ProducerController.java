package com.example.demo.controller;

import com.example.demo.entities.Producer;
import com.example.demo.service.ProducerService;
import com.example.demo.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService service;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Producer>> getAll(@RequestParam(required = false, defaultValue = "10") int size,
                                                   @RequestParam(required = false,defaultValue = "1") int page){

        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Producer getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Producer create(@RequestBody Producer producer) {
        return service.create(producer);
    }

    @PutMapping("/update")
    public Producer update( @RequestBody Producer producer) {
        return service.update(producer);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
