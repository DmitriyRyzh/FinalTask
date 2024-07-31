package com.rdm.rdm.service;

import com.rdm.rdm.entity.OrderDb;
import com.rdm.rdm.repo.OrderDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDbService {

    @Autowired
    private OrderDbRepository orderDbRepository;

    public Optional<OrderDb> findById(Long id){
        return orderDbRepository.findById(id);
    }

    public OrderDb saveOrder(OrderDb orderDb) {
        return orderDbRepository.save(orderDb);
    }

    public Optional<OrderDb> findByServiceId(Long id){
        return orderDbRepository.findByServiceId(id);
    }
}
