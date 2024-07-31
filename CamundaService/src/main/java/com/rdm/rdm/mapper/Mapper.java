package com.rdm.rdm.mapper;

import com.rdm.rdm.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Mapper {

    public CheckItemsEntity InputOrderToCheckItems(OrderEntity orderEntity){
        Set<Item> items = new HashSet<Item>();
        for(ItemEntity itemEntity : orderEntity.getItems())
        {
            items.add(new Item(itemEntity.getCode(), itemEntity.getQuantity()));
        }
        return new CheckItemsEntity(items, orderEntity.getId());
    }

    public ReturnItemsEntity InputOrderToReturnItems(OrderEntity orderEntity){
        Set<Item> items = new HashSet<Item>();
        for(ItemEntity itemEntity : orderEntity.getItems())
        {
            items.add(new Item(itemEntity.getCode(), itemEntity.getQuantity()));
        }
        return new ReturnItemsEntity(items, orderEntity.getId());
    }

    public OrderToAssembly InputOrderToOrderAssembly(OrderEntity orderEntity){
        Set<Item> items = new HashSet<Item>();
        for(ItemEntity itemEntity : orderEntity.getItems())
        {
            items.add(new Item(itemEntity.getCode(), itemEntity.getQuantity()));
        }
        return new OrderToAssembly(orderEntity.getId(), items);
    }

    public OrderToPackaging InputOrderToOrderPackaging(OrderEntity orderEntity){

        return new OrderToPackaging(orderEntity.getId());
    }

    public OrderToDelivery InputOrderToOrderDelivery(OrderEntity orderEntity){

        return new OrderToDelivery(orderEntity.getAddress(), orderEntity.getClientname(),
                orderEntity.getId());
    }


}
