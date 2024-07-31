package com.rdm.rdm.bpm.delegate;

import com.rdm.rdm.entity.OrderEntity;
import com.rdm.rdm.entity.ReturnItemsEntity;
import com.rdm.rdm.interfaces.CheckAvailableItems;
import com.rdm.rdm.interfaces.ReturnItems;
import com.rdm.rdm.mapper.Mapper;
import com.rdm.rdm.rest.CheckAvailableItemsRest;
import com.rdm.rdm.rest.ReturnItemsRest;
import com.rdm.rdm.rest.service.CheckAvailableItemsService;
import com.rdm.rdm.rest.service.ReturnItemsService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ReturnToWarehouseDelegate implements JavaDelegate {

    private final Logger log = LoggerFactory.getLogger(CheckAvailableItemsService.class);

    //@Autowired
    //ReturnItemsService returnItemsService;

    ReturnItems returnItems = new ReturnItemsRest();

    Mapper mapper = new Mapper();

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        OrderEntity orderEntity = (OrderEntity) delegateExecution.getVariable("orderEntity");
        ReturnItemsEntity returnItemsEntity = mapper.InputOrderToReturnItems(orderEntity);
        returnItems.returnItems(returnItemsEntity);

    }
}
