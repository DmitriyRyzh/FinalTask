package com.rdm.rdm.interfaces;

import com.rdm.rdm.entity.CheckItemsEntity;
import com.rdm.rdm.entity.OrderToPackaging;

public interface OrderToPackagingSend {
    String send(OrderToPackaging orderToPackaging);
}
