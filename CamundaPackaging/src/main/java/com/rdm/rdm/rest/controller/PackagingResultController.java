package com.rdm.rdm.rest.controller;

import com.rdm.rdm.Interfaces.PackagingOrder;
import com.rdm.rdm.entity.PackagingResultEntity;
import com.rdm.rdm.entity.SendToServiceEntity;
import com.rdm.rdm.rest.PackagingOrderRest;
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
public class PackagingResultController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PackagingOrder packagingOrder = new PackagingOrderRest();

    @PostMapping
    public void result(@RequestBody PackagingResultEntity packagingResultEntity) {
        logger.info("Получен результат упаковки заказа № " + packagingResultEntity.getId() +
                " со статусом: " + packagingResultEntity.getIsSuccess());

        SendToServiceEntity sendToServiceEntity =
                new SendToServiceEntity(packagingResultEntity.getIsSuccess(),
                packagingResultEntity.getId());

        logger.info("Отправляем нотификацию в Service по заказу № " + packagingResultEntity.getId());
        packagingOrder.send(sendToServiceEntity);
    }

}
