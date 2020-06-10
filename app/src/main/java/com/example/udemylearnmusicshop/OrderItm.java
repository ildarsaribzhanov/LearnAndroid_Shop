package com.example.udemylearnmusicshop;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderItm implements Parcelable {
    String instrument;

    Integer amount;

    Double cost;

    OrderItm() {
    }

    OrderItm(String instrument, int amount, Double cost) {
        this.instrument = instrument;
        this.amount = amount;
        this.cost = cost;
    }

    public OrderItm(Parcel in) {
        String[] data = new String[3];
        in.readStringArray(data);
        instrument = data[0];
        amount = Integer.parseInt(data[1]);
        cost = Double.parseDouble(data[2]);
    }

    public Double getTotalPrice() {
        return amount * cost;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", instrument='" + instrument + '\'' +
                ", amount=" + amount +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{instrument, amount.toString(), cost.toString()});
    }

    public static final Parcelable.Creator<OrderItm> CREATOR = new Parcelable.Creator<OrderItm>() {

        @Override
        public OrderItm createFromParcel(Parcel source) {
            return new OrderItm(source);
        }

        @Override
        public OrderItm[] newArray(int size) {
            return new OrderItm[size];
        }
    };
}
