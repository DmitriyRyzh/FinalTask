package com.rdm.rdm.rest.controller;

import com.rdm.rdm.entity.*;
import com.rdm.rdm.service.OrderDbService;
import com.rdm.rdm.service.StatusDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/assembly")
public class AssemblyController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StatusDbService statusDbService;
    @Autowired
    private OrderDbService orderDbService;


    @PostMapping
    public OrderInputRs assembly(@RequestBody OrderInput orderInput) {
        logger.info(orderInput.toString());
        Set<OrderItemDb> items = new HashSet<OrderItemDb>();
        for(ItemInput itemInput : orderInput.getItems())
        {
            items.add(new OrderItemDb(null, itemInput.getCode(), itemInput.getQuantity()));
        }


        OrderDb orderDb = new OrderDb(null, statusDbService.findByStatusCode("New"),
                LocalDateTime.now(),
                items, orderInput.getId());
        logger.info("Items: " + orderDb.getItems().size());

        orderDbService.saveOrder(orderDb); // сохранение в базу

        return new OrderInputRs("Y");
    }

}
