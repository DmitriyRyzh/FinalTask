package com.rdm.rdm.rest;

import com.rdm.rdm.entity.OrderToAssembly;
import com.rdm.rdm.interfaces.OrderToAssemblySend;
import com.rdm.rdm.rest.service.SendToAssemblyService;

public class OrderToAssemblySendRest implements OrderToAssemblySend {
    @Override
    public String send(OrderToAssembly orderToAssembly) {
        SendToAssemblyService sendToAssemblyService = new SendToAssemblyService();
        return sendToAssemblyService.SendToAssembly(orderToAssembly);
    }
}
