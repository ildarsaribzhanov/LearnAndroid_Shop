package com.example.udemylearnmusicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incQuantity(View view) {
        TextView quantityVal = findViewById(R.id.quantityVal);

        if (quantity <= 1) {
            return;
        }

        quantity--;
        quantityVal.setText(Integer.toString(quantity));
    }

    public void decQuantity(View view) {
        TextView quantityVal = findViewById(R.id.quantityVal);
        quantity++;
        quantityVal.setText(Integer.toString(quantity));
    }
}