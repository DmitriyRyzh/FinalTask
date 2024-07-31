package com.rdm.rdm.bpm.delegate;

import com.rdm.rdm.entity.ChangeStatusEntity;
import com.rdm.rdm.entity.OrderEntity;
import com.rdm.rdm.interfaces.StatusSend;
import com.rdm.rdm.mapper.Mapper;
import com.rdm.rdm.rest.StatusSendRest;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotifyOrderDelegate implements JavaDelegate {

    @Autowired
    RuntimeService runtimeService;

    StatusSend statusSend = new StatusSendRest();

    Mapper mapper = new Mapper();


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        // Send status
        OrderEntity orderEntity = (OrderEntity) delegateExecution.getVariable("orderEntity");
        ChangeStatusEntity changeStatusEntity = new ChangeStatusEntity(orderEntity.getId(),
                delegateExecution.getVariable("status").toString());
        statusSend.send(changeStatusEntity);
    }
}
