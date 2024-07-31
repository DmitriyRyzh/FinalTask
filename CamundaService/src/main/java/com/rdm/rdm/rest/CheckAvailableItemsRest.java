package com.rdm.rdm.rest;

import com.rdm.rdm.entity.CheckItemsEntity;
import com.rdm.rdm.interfaces.CheckAvailableItems;
import com.rdm.rdm.rest.service.CheckAvailableItemsService;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckAvailableItemsRest implements CheckAvailableItems {

    @Override
    public String check(CheckItemsEntity checkItemsEntity) {
        CheckAvailableItemsService checkAvailableItemsService = new CheckAvailableItemsService();
        return checkAvailableItemsService.checkItems(checkItemsEntity);
    }

}
