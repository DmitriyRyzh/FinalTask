package com.rdm.rdm.controller;

import com.rdm.rdm.entity.OrderDb;
import com.rdm.rdm.entity.OrderInput;
import com.rdm.rdm.entity.OrderInputRs;
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
@RequestMapping("/delivery")
public class ReceiveOrderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StatusDbService statusDbService;
    @Autowired
    private OrderDbService orderDbService;

    @PostMapping
    public OrderInputRs order(@RequestBody OrderInput orderInput) {
        logger.info(orderInput.toString());

        OrderDb orderDb = new OrderDb(null, statusDbService.findByStatusCode("New"),
                LocalDateTime.now(),
                orderInput.getAddress(), orderInput.getClientname(),
                orderInput.getOrderId());
        logger.info(orderDb.getClientname());

        orderDbService.saveOrder(orderDb); // сохранение в базу

        return new OrderInputRs("Y");

    }

}
