package com.huobi.api.client.domain;

import com.huobi.api.client.domain.enums.OrderSide;
import lombok.Data;

/**
 * created by jacky. 2018/7/21 2:33 PM
 */
@Data
public class Trade {
    private String id;
    private double price;
    private double amount;
    private OrderSide direction;
    private long ts;
}
