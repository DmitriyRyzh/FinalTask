package com.rdm.rdm.bpm.delegate;

import com.rdm.rdm.entity.OrderEntity;
import com.rdm.rdm.entity.OrderToDelivery;
import com.rdm.rdm.interfaces.OrderToDeliverySend;
import com.rdm.rdm.interfaces.OrderToPackagingSend;
import com.rdm.rdm.mapper.Mapper;
import com.rdm.rdm.rest.OrderToDeliverySendRest;
import com.rdm.rdm.rest.OrderToPackagingSendRest;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class SendToDeliveryDelegate  implements JavaDelegate {

    @Autowired
    RuntimeService runtimeService;

    OrderToDeliverySend orderToDeliverySend = new OrderToDeliverySendRest();

    Mapper mapper = new Mapper();

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        // Send to Delivery
        OrderEntity orderEntity = (OrderEntity) delegateExecution.getVariable("orderEntity");
        OrderToDelivery orderToDelivery = mapper.InputOrderToOrderDelivery(orderEntity);
        orderToDeliverySend.send(orderToDelivery);
    }
}
