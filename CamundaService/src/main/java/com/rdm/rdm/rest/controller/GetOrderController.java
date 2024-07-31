package com.rdm.rdm.rest.controller;

import com.rdm.rdm.entity.*;
import com.rdm.rdm.interfaces.*;
import com.rdm.rdm.mapper.Mapper;
import com.rdm.rdm.rest.*;
import org.camunda.bpm.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/order")
public class GetOrderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RuntimeService runtimeService;

    CheckAvailableItems checkAvailableItems = new CheckAvailableItemsRest();

    Mapper mapper = new Mapper();


    @PostMapping
    public OrderEntityRs order(@RequestBody OrderEntity orderEntity) {

        logger.info("Пришел запрос на обработку заявки:       "+ orderEntity.getId() );

        HashMap<String, Object> mapVariables = new HashMap<String, Object>();
        mapVariables.put("orderEntity", orderEntity);
        mapVariables.put("available","N");
        mapVariables.put("status","New");
        mapVariables.put("assemblySuccess","N");
        mapVariables.put("packagingSuccess","N");
        mapVariables.put("deliverySuccess","N");

        runtimeService.startProcessInstanceByKey("Process_1", orderEntity.getId().toString(),
                mapVariables);

        return new OrderEntityRs("Y");
    }
}
