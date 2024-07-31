package com.rdm.rdm.controller;

import com.rdm.rdm.entity.*;
import com.rdm.rdm.interfaces.SendOrderToService;
import com.rdm.rdm.repo.ItemDbRepository;
import com.rdm.rdm.repo.OrderDbRepository;
import com.rdm.rdm.repo.StatusDbRepository;
import com.rdm.rdm.rest.SendOrderToServiceRest;
import com.rdm.rdm.service.OrderDbService;
import com.rdm.rdm.service.StatusDbService;
import com.rdm.rdm.utils.OrderMapping;
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
@RequestMapping("/newOrder")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StatusDbService statusDbService;

    @Autowired
    private OrderDbService orderDbService;

    private SendOrderToService sendOrderToService = new SendOrderToServiceRest();

    private OrderMapping orderMapping = new OrderMapping();

    @PostMapping
    public void newOrder(@RequestBody OrderInput orderInput) {
        logger.info(orderInput.toString());
        Set<ItemDb> items = new HashSet<ItemDb>();
        for(ItemInput itemInput : orderInput.getItems())
        {
            items.add(new ItemDb(null, itemInput.getCode(), itemInput.getQuantity()));
        }
        OrderDb orderDb = new OrderDb(null, statusDbService.findByStatusCode("New"),
                LocalDateTime.now(),
                orderInput.getAddress(), orderInput.getClientname(), items);

        orderDbService.saveOrder(orderDb); // сохранение в базу

        OrderOutput orderOutput = orderMapping.OrderInputToOutput(orderDb);
        sendOrderToService.send(orderOutput); // отправка заказа в сервис

    }

}
