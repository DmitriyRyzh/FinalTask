package com.rdm.rdm.bpm.delegate;

import com.rdm.rdm.entity.CheckItemsEntity;
import com.rdm.rdm.entity.OrderEntity;
import com.rdm.rdm.interfaces.CheckAvailableItems;
import com.rdm.rdm.mapper.Mapper;
import com.rdm.rdm.rest.CheckAvailableItemsRest;
import com.rdm.rdm.rest.service.CheckAvailableItemsService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckAvailableItemsDelegate implements JavaDelegate {

    private final Logger log = LoggerFactory.getLogger(CheckAvailableItemsService.class);

    CheckAvailableItems checkAvailableItems = new CheckAvailableItemsRest();

    Mapper mapper = new Mapper();

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        OrderEntity orderEntity = (OrderEntity) delegateExecution.getVariable("orderEntity");

        CheckItemsEntity checkItemsEntity = mapper.InputOrderToCheckItems(orderEntity);
        String result = checkAvailableItems.check(checkItemsEntity);

        delegateExecution.setVariable("available", result);
        if(result.equals("Y")){
            delegateExecution.setVariable("status", "TransferredToAssembling");
        } else {
            delegateExecution.setVariable("status", "NoItems");
        }

    }
}
