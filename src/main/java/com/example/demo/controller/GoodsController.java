package com.example.demo.controller;

import com.example.demo.entities.Goods;
import com.example.demo.service.GoodsService;
import com.example.demo.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService service;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Goods>> getAll(@RequestParam(required = false, defaultValue = "10") int size,
                                                   @RequestParam(required = false,defaultValue = "1") int page){

        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Goods getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Goods create(@RequestBody Goods goods) {
        return service.create(goods);
    }

    @PutMapping("/update")
    public Goods update( @RequestBody Goods goods) {
        return service.update(goods);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
