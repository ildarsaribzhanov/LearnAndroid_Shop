package com.example.udemylearnmusicshop;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {
    String userName;

    String instrument;

    Integer amount;

    Order() {
    }

    Order(String userName, String instrument, int amount) {
        this.userName = userName;
        this.instrument = instrument;
        this.amount = amount;
    }

    public Order(Parcel in) {
        String[] data = new String[3];
        in.readStringArray(data);
        userName = data[0];
        instrument = data[1];
        amount = Integer.parseInt(data[2]);
    }

    @Override
    public String toString() {
        return "Order{" +
                "userName='" + userName + '\'' +
                ", instrument='" + instrument + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{userName, instrument, amount.toString()});
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
