package com.rdm.rdm.controller;

import com.rdm.rdm.entity.*;
import com.rdm.rdm.interfaces.SendOrderToService;
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
@RequestMapping("/changeStatus")
public class ChangeStatusController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StatusDbService statusDbService;
    @Autowired
    private OrderDbService orderDbService;

    @PostMapping
    public ChangeStatusEntityRs changeStatus(@RequestBody ChangeStatusEntity changeStatusEntity) {
        logger.info("Статус заявки № " + changeStatusEntity.getId()
                + " изменился на " + changeStatusEntity.getStatus());

        OrderDb orderDb = orderDbService.findById(changeStatusEntity.getId()).get();
        StatusDb statusDb = statusDbService.findByStatusCode(changeStatusEntity.getStatus());
        orderDb.setStatusDb(statusDb);

        orderDbService.saveOrder(orderDb); // сохранение в базу

        return new ChangeStatusEntityRs("Y");

    }

}
