package com.example.demo.controller;

import com.example.demo.entities.Person;
import com.example.demo.service.PersonService;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Person>> getAll(@RequestParam(required = false, defaultValue = "10") int size,
                                                   @RequestParam(required = false,defaultValue = "1") int page){

        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Person getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping("/update")
    public Person update( @RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
