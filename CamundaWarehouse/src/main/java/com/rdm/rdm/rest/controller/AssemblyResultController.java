package com.rdm.rdm.rest.controller;

import com.rdm.rdm.Interfaces.AssemblingOrder;
import com.rdm.rdm.entity.AssemblyResultEntity;
import com.rdm.rdm.entity.OrderDb;
import com.rdm.rdm.entity.SendToServiceEntity;
import com.rdm.rdm.rest.AssemblingOrderRest;
import com.rdm.rdm.service.OrderDbService;
import com.rdm.rdm.service.StatusDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/result")
public class AssemblyResultController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StatusDbService statusDbService;
    @Autowired
    private OrderDbService orderDbService;

    private final AssemblingOrder assemblingOrder = new AssemblingOrderRest();

    @PostMapping
    public void result(@RequestBody AssemblyResultEntity assemblyResultEntity) {
        logger.info("Завершилась сборка по заявке: " + assemblyResultEntity.getId() +
                " , результат: " + assemblyResultEntity.getIsSuccess());

        Long id = assemblyResultEntity.getId();
        Optional<OrderDb> orderDb = orderDbService.findByServiceId(id);
        if (assemblyResultEntity.getIsSuccess().equals("Y")) {
            orderDb.get().setStatusDb(statusDbService.findByStatusCode("Assembled"));
        } else {
            orderDb.get().setStatusDb(statusDbService.findByStatusCode("NotAssembled"));
        }

        SendToServiceEntity sendToService =
                new SendToServiceEntity(assemblyResultEntity.getIsSuccess(),
                assemblyResultEntity.getId());

        assemblingOrder.send(sendToService);
    }

}
