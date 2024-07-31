package com.rdm.rdm.rest;

import com.rdm.rdm.entity.OrderOutput;
import com.rdm.rdm.interfaces.SendOrderToService;
import com.rdm.rdm.rest.service.SendOrderService;

public class SendOrderToServiceRest implements SendOrderToService {

    @Override
    public String send(OrderOutput orderOutput) {

        SendOrderService sendOrderService = new SendOrderService();

        sendOrderService.sendOrder(orderOutput);

        return null;
    }
}
