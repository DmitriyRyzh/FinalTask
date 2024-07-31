package com.rdm.rdm.rest;

import com.rdm.rdm.entity.OrderToDelivery;
import com.rdm.rdm.interfaces.OrderToDeliverySend;
import com.rdm.rdm.rest.service.SendToDeliveryService;

public class OrderToDeliverySendRest implements OrderToDeliverySend {
    @Override
    public String send(OrderToDelivery orderToDelivery) {
        SendToDeliveryService sendToDeliveryService = new SendToDeliveryService();
        return sendToDeliveryService.SendToDelivery(orderToDelivery);
    }
}
