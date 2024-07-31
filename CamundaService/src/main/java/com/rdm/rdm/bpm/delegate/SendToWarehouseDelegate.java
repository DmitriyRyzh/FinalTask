package com.rdm.rdm.bpm.delegate;

import com.rdm.rdm.entity.OrderEntity;
import com.rdm.rdm.entity.OrderToAssembly;
import com.rdm.rdm.interfaces.OrderToAssemblySend;
import com.rdm.rdm.mapper.Mapper;
import com.rdm.rdm.rest.OrderToAssemblySendRest;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class SendToWarehouseDelegate implements JavaDelegate {


    @Autowired
    RuntimeService runtimeService;

    OrderToAssemblySend orderToAssemblySend = new OrderToAssemblySendRest();

    Mapper mapper = new Mapper();
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        // Send to warehouse
        OrderEntity orderEntity = (OrderEntity) delegateExecution.getVariable("orderEntity");
        OrderToAssembly orderToAssembly = mapper.InputOrderToOrderAssembly(orderEntity);
        orderToAssemblySend.send(orderToAssembly);
    }
}
