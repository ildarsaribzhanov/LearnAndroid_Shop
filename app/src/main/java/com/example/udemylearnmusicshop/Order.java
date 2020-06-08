package com.example.udemylearnmusicshop;

public class Order {
    String userName;

    String instrument;

    int amount;

    Order() {
    }

    Order(String userName, String instrument, int amount) {
        this.userName = userName;
        this.instrument = instrument;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userName='" + userName + '\'' +
                ", instrument='" + instrument + '\'' +
                ", amount=" + amount +
                '}';
    }
}
