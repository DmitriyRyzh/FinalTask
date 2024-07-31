package com.rdm.rdm.rest.controller;

import com.rdm.rdm.entity.OrderInput;
import com.rdm.rdm.entity.OrderInputRs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/packaging")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public OrderInputRs packaging(@RequestBody OrderInput orderInput) {
        logger.info("Получен запрос на упаковку заказа №       "+ orderInput.getId());
        return (new OrderInputRs("Success"));
    }
}
