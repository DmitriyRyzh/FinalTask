package com.rdm.rdm.rest;

import com.rdm.rdm.entity.ReturnItemsEntity;
import com.rdm.rdm.interfaces.ReturnItems;
import com.rdm.rdm.rest.service.ReturnItemsService;

public class ReturnItemsRest implements ReturnItems {
    @Override
    public String returnItems(ReturnItemsEntity returnItemsEntity) {
        ReturnItemsService returnItemsService = new ReturnItemsService();
        return returnItemsService.returnItems(returnItemsEntity);
    }
}
