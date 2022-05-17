package com.example.demo.service;

import com.example.demo.DTO.OrderCreateRequest;
import com.example.demo.DTO.OrderDTO;
import com.example.demo.DTO.OrderUpdateRequest;
import com.example.demo.entities.Goods;
import com.example.demo.entities.Order;
import com.example.demo.entities.Person;
import com.example.demo.entities.Producer;
import com.example.demo.repository.OrderRepo;
import com.example.demo.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo repo;

    public Page<OrderDTO> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> orders = repo.findAll(pageable);

        var ordersDTOs = orders.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<OrderDTO>(ordersDTOs);

    };
    public OrderDTO getById(Long id) {
        return convertToDTO(repo.getById(id));
    }

    public OrderDTO create(OrderCreateRequest order){

        Producer producer = Producer.builder().id(order.getProducer_id())
                .name(order.getProducer()).country(order.getProducer_country()).build();

        Person contacts = Person.builder()
                .id(order.getResponsiblePersonId())
                .name(order.getResponsiblePersonName())
                .telephone(order.getResponsiblePersonTelephone()).build();
       return convertToDTO(repo.save(Order.builder().producer(producer)
                    .contacts(contacts).build()));
    }

    public OrderDTO update(OrderUpdateRequest order){
        Long id = order.getId();
        Order order1 = repo.getById(id);
        repo.deleteById(id);
        return convertToDTO(repo.save(Order.builder().id(order.getId())
                    .producer(order1.getProducer())
                    .contacts(order1.getContacts())
                    .orderList(order1.getOrderList()).build()));


    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Order " + id + " deleted succesfully";
    }
    public double getSumOfOrder(List<Goods> goods){
        double sumOfOrder = 0;
        for (Goods good: goods
             ) {
            sumOfOrder+=good.getPurchasePricePerUnit()*good.getNum();
        }
        return sumOfOrder;
    }

    public List<Long> getGoodsIds(List<Goods> goods){
        List<Long> ids = new ArrayList<>();
        for (Goods item: goods
             ) {
            ids.add(item.getId());
        }
        return ids;
    }

    public OrderDTO convertToDTO(Order entity) {
        List<Long> orders = new ArrayList<>();
        for (Goods item: entity.getOrderList()
             ) {
            orders.add(item.getId());
        }
        return OrderDTO.builder()
                .id(entity.getId())
                .producer_id(entity.getProducer().getId())
                .producer(entity.getProducer().getName())
                .producer_country(entity.getProducer().getCountry())
                .goodsId(orders)
              //  .sumOfOrder(getSumOfOrder(entity))
                .responsiblePersonId(entity.getContacts().getId())
                .responsiblePersonName(entity.getContacts().getName())
                .responsiblePersonTelephone(entity.getContacts().getTelephone())
                .build();
    }

}
