package com.rdm.rdm.rest;

import com.rdm.rdm.Interfaces.PackagingOrder;
import com.rdm.rdm.entity.SendToServiceEntity;
import com.rdm.rdm.rest.service.SendOrderRs;

public class PackagingOrderRest implements PackagingOrder {
    public void send(SendToServiceEntity sendToServiceEntity){

        SendOrderRs sendOrderRs = new SendOrderRs();
        sendOrderRs.sendRs(sendToServiceEntity);
    }
}
