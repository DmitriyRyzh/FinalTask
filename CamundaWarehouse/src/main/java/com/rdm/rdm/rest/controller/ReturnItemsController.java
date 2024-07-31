package com.rdm.rdm.rest.controller;

import com.rdm.rdm.entity.*;
import com.rdm.rdm.service.StoredItemsDbDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/returnitems")
public class ReturnItemsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StoredItemsDbDbService storedItemsDbDbService;

    @PostMapping
    public ReturnItemsRsEntity result(@RequestBody ReturnItemsEntity returnItemsEntity) {
        logger.info("Проверка наличия по заказу: " + returnItemsEntity.getOrderID());

        for (Item item : returnItemsEntity.getItems()) {
            StoredItemsDb storedItemsDb = storedItemsDbDbService.findByItemCode(item.getCode()).get();
            storedItemsDb.setQuantity(storedItemsDb.getQuantity() + item.getQuantity());
            storedItemsDbDbService.save(storedItemsDb);
        }

        return new ReturnItemsRsEntity("Y");
    }



}
