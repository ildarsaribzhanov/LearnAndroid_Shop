package com.example.udemylearnmusicshop;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {
    String userName;

    String instrument;

    Integer amount;

    Double cost;

    Order() {
    }

    Order(String userName, String instrument, int amount, Double cost) {
        this.userName = userName;
        this.instrument = instrument;
        this.amount = amount;
        this.cost = cost;
    }

    public Order(Parcel in) {
        String[] data = new String[4];
        in.readStringArray(data);
        userName = data[0];
        instrument = data[1];
        amount = Integer.parseInt(data[2]);
        cost = Double.parseDouble(data[3]);
    }

    public Double getTotalPrice() {
        return amount * cost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userName='" + userName + '\'' +
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
        dest.writeStringArray(new String[]{userName, instrument, amount.toString(), cost.toString()});
    }

    public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>() {

        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
