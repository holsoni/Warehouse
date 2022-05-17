package com.example.demo.service;

import com.example.demo.entities.Person;
import com.example.demo.repository.PersonRepo;
import com.example.demo.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepo repo;

    public Page<Person> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);

    };
    public Person getById(Long id) {
        return repo.getById(id);
    }

    public Person create(Person person){
       return repo.save(person);
    }

    public Person update(Person person){
        Long id = person.getId();
        repo.deleteById(id);
        repo.save(person);
        person.setId(id);
        return person;
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Person " + id + " deleted succesfully";
    }

}
