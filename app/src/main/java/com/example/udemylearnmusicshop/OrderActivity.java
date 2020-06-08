package com.example.udemylearnmusicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent orderIntent = getIntent();

        Order order = (Order) orderIntent.getParcelableExtra("order");

        setLayoutData(order);
    }

    public void setLayoutData(Order order) {
        TextView userView = findViewById(R.id.orderUserName);
        TextView instrumentView = findViewById(R.id.orderInstrument);
        TextView quantityView = findViewById(R.id.orderAmount);
        TextView priceView = findViewById(R.id.orderPrice);
        TextView TotalPriceView = findViewById(R.id.orderTotalPrice);

        userView.setText(order.userName);
        instrumentView.setText(order.instrument);
        quantityView.setText(order.amount.toString());
        priceView.setText(order.cost.toString());
        TotalPriceView.setText(order.getTotalPrice().toString());
    }
}