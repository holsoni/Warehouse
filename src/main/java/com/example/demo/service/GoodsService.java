package com.example.demo.service;

import com.example.demo.entities.Goods;
import com.example.demo.repository.GoodsRepo;
import com.example.demo.repository.GoodsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepo repo;

    public Page<Goods> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Goods getById(Long id) {
        return repo.getById(id);
    }

    public Goods create(Goods goods){
       return repo.save(goods);
    }

    public Goods update(Goods goods){
        Long id = goods.getId();
        repo.deleteById(id);
        repo.save(goods);
        goods.setId(id);
        return goods;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Goods " + id + " deleted succesfully";
    }

}
