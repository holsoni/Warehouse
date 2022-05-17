package com.example.demo.service;

import com.example.demo.entities.Producer;
import com.example.demo.repository.ProducerRepo;
import com.example.demo.repository.ProducerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final ProducerRepo repo;

    public Page<Producer> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Producer getById(Long id) {
        return repo.getById(id);
    }

    public Producer create(Producer producer){
       return repo.save(producer);
    }

    public Producer update(Producer producer){
        Long id = producer.getId();
        repo.deleteById(id);
        repo.save(producer);
        producer.setId(id);
        return producer;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Producer " + id + " deleted succesfully";
    }

}
