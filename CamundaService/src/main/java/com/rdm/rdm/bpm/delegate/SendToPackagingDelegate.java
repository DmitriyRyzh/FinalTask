package com.rdm.rdm.bpm.delegate;

import com.rdm.rdm.entity.OrderEntity;
import com.rdm.rdm.entity.OrderToPackaging;
import com.rdm.rdm.interfaces.OrderToPackagingSend;
import com.rdm.rdm.mapper.Mapper;
import com.rdm.rdm.rest.OrderToPackagingSendRest;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class SendToPackagingDelegate implements JavaDelegate {

    @Autowired
    RuntimeService runtimeService;

    OrderToPackagingSend orderToPackagingSend = new OrderToPackagingSendRest();

    Mapper mapper = new Mapper();

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        OrderEntity orderEntity = (OrderEntity) delegateExecution.getVariable("orderEntity");
        OrderToPackaging orderToPackaging = mapper.InputOrderToOrderPackaging(orderEntity);
        orderToPackagingSend.send(orderToPackaging);
    }
}
