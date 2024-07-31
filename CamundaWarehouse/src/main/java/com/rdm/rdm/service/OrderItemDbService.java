package com.rdm.rdm.service;

import com.rdm.rdm.entity.OrderItemDb;
import com.rdm.rdm.repo.OrderItemDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemDbService {

    @Autowired
    private OrderItemDbRepository orderItemDbRepository;

    public Optional<OrderItemDb> findById(Long id){
        return orderItemDbRepository.findById(id);
    }
}
