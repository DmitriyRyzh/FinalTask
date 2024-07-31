package com.rdm.rdm.rest;

import com.rdm.rdm.entity.OrderToPackaging;
import com.rdm.rdm.entity.SendToPackagingRs;
import com.rdm.rdm.interfaces.OrderToPackagingSend;
import com.rdm.rdm.rest.service.SendToPackagingService;

public class OrderToPackagingSendRest implements OrderToPackagingSend {
    @Override
    public String send(OrderToPackaging orderToPackaging) {
        SendToPackagingService sendToPackagingService = new SendToPackagingService();
        return sendToPackagingService.SendToPackaging(orderToPackaging);
    }
}
