package com.rdm.rdm.rest;

import com.rdm.rdm.entity.ChangeStatusEntity;
import com.rdm.rdm.interfaces.StatusSend;
import com.rdm.rdm.rest.service.SendStatusService;

public class StatusSendRest implements StatusSend {
    @Override
    public String send(ChangeStatusEntity changeStatusEntity) {
        SendStatusService sendStatusService = new SendStatusService();
        return sendStatusService.SendStatus(changeStatusEntity);
    }
}
