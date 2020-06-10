package com.example.udemylearnmusicshop;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Basket implements Parcelable {
    HashMap<String, OrderItm> items = new HashMap<>();

    public Basket() {
    }

    protected Basket(Parcel in) {
        ArrayList instruments = new ArrayList<OrderItm>();

        in.readList(instruments, OrderItm.class.getClassLoader());

        for (int i = 0; i < instruments.size(); i++) {
            OrderItm orderItm = (OrderItm) instruments.get(i);
            items.put(orderItm.instrument, orderItm);
        }
    }

    public void addItem(OrderItm itm) {
        if (items.get(itm.instrument) != null) {
            items.get(itm.instrument).amount += itm.amount;
            return;
        }

        items.put(itm.instrument, itm);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "items=" + items +
                '}';
    }

    public Double getTotalPrice() {
        Double totalPrice = 0.0;

        for (Map.Entry<String, OrderItm> instrument : items.entrySet()) {
            totalPrice += instrument.getValue().getTotalPrice();
        }

        return totalPrice;
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        String[] res = {};

        dest.writeList(new ArrayList(items.values()));
    }

    public static final Creator<Basket> CREATOR = new Creator<Basket>() {
        @Override
        public Basket createFromParcel(Parcel in) {
            return new Basket(in);
        }

        @Override
        public Basket[] newArray(int size) {
            return new Basket[size];
        }
    };
}

