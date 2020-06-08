package com.example.udemylearnmusicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent orderIntent = getIntent();

        Order order = (Order) orderIntent.getParcelableExtra("order");
    }
}