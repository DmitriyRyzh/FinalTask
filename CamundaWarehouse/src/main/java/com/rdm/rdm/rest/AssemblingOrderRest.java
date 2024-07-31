package com.rdm.rdm.rest;

import com.rdm.rdm.Interfaces.AssemblingOrder;
import com.rdm.rdm.entity.SendToServiceEntity;
import com.rdm.rdm.rest.service.SendOrderRs;

public class AssemblingOrderRest implements AssemblingOrder {

    public void send(SendToServiceEntity sendToServiceEntity){

        SendOrderRs sendOrderRs = new SendOrderRs();
        sendOrderRs.sendRs(sendToServiceEntity);
    }
}
