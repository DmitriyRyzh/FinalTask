package com.rdm.rdm.interfaces;

import com.rdm.rdm.entity.OrderOutput;

public interface SendOrderToService {
    String send(OrderOutput orderOutput);
}
