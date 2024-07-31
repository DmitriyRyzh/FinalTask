package com.rdm.rdm.rest;

import com.rdm.rdm.Interfaces.SendResultToService;
import com.rdm.rdm.entity.SendToService;
import com.rdm.rdm.rest.service.SendOrderRs;

public class SendResultToServiceRest implements SendResultToService {
    public void send(SendToService sendToService){

        SendOrderRs sendOrderRs = new SendOrderRs();
        sendOrderRs.sendRs(sendToService);
    }
}
