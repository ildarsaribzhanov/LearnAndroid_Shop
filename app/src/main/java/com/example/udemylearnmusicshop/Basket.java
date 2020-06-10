package com.example.udemylearnmusicshop;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    HashMap<String, OrderItm> items = new HashMap<>();

    public void addItem(OrderItm itm) {
        if (items.get(itm.instrument) != null) {
            items.get(itm.instrument).amount += itm.amount;
            return;
        }

        items.put(itm.instrument, itm);
    }

    public Double getTotalPrice() {
        Double totalPrice = 0.0;

        for (Map.Entry<String, OrderItm> instrument : items.entrySet()) {
            totalPrice += instrument.getValue().getTotalPrice();
        }

        return totalPrice;
    }
}
