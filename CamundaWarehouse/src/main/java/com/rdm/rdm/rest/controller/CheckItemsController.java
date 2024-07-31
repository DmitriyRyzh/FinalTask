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
@RequestMapping(path = "/checkitems")
public class CheckItemsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StoredItemsDbDbService storedItemsDbDbService;

    @PostMapping
    public CheckItemsRsEntity result(@RequestBody CheckItemsEntity checkItemsEntity) {
        logger.info("Проверка наличия по заказу: " + checkItemsEntity.getOrderID());

        // Проверка наличия
        String isAvailable = "Y";
        for (Item item : checkItemsEntity.getItems()){
            if(item.getQuantity() >
                    storedItemsDbDbService.findByItemCode(item.getCode()).get().getQuantity() ){
                isAvailable = "N";
                break;
            }
        }
        // резервирование, в случае если товары есть
        if (isAvailable == "Y"){
            for (Item item : checkItemsEntity.getItems()){
                StoredItemsDb storedItemsDb = storedItemsDbDbService.findByItemCode(item.getCode()).get();
                storedItemsDb.setQuantity(storedItemsDb.getQuantity() - item.getQuantity());
                storedItemsDbDbService.save(storedItemsDb);
            }
        }


        return new CheckItemsRsEntity(isAvailable);
    }
}
