package com.rdm.rdm.utils;

import com.rdm.rdm.entity.*;

import java.util.HashSet;
import java.util.Set;

public class OrderMapping {

    public OrderOutput OrderInputToOutput(OrderDb orderDb){
        Set<ItemInput> items = new HashSet<ItemInput>();
        for(ItemDb itemDb : orderDb.getItems())
        {
            items.add(new ItemInput(itemDb.getCode(), itemDb.getQuantity()));
        }
        return (new OrderOutput(orderDb.getId(), orderDb.getAddress(), orderDb.getClientname(),
                items));
    }
}
