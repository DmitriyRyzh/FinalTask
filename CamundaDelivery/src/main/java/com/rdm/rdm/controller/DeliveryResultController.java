package com.rdm.rdm.controller;

import com.rdm.rdm.Interfaces.SendResultToService;
import com.rdm.rdm.entity.DeliveryResultEntity;
import com.rdm.rdm.entity.OrderDb;
import com.rdm.rdm.entity.OrderInput;
import com.rdm.rdm.entity.SendToService;
import com.rdm.rdm.rest.SendResultToServiceRest;
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
public class DeliveryResultController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StatusDbService statusDbService;
    @Autowired
    private OrderDbService orderDbService;
    private final SendResultToService sendResultToService = new SendResultToServiceRest();

    @PostMapping
    public void result(@RequestBody DeliveryResultEntity deliveryResultEntity) {
        logger.info("Получили результат доставки по заявке № " + deliveryResultEntity.getId()
            + " . Результат: " + deliveryResultEntity.getIsSuccess());

        Long id = deliveryResultEntity.getId();
        //System.out.println("id:           " + id);
        Optional<OrderDb> orderDb = orderDbService.findByOrderId(id);
        if (deliveryResultEntity.getIsSuccess().equals("Y")) {
            logger.info("Меняем статус на Delivered");
            orderDb.get().setStatusDb(statusDbService.findByStatusCode("Delivered"));
        } else {
            logger.info("Меняем статус на NotDelivered");
            orderDb.get().setStatusDb(statusDbService.findByStatusCode("NotDelivered"));
        }

        orderDbService.saveOrder(orderDb.get());
        logger.info("Изменили статус по заявке № " + deliveryResultEntity.getId());

                SendToService sendToService = new SendToService(deliveryResultEntity.getIsSuccess(),
                deliveryResultEntity.getId());

        sendResultToService.send(sendToService);
    }

}
