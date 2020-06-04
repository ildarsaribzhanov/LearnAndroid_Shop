package com.example.udemylearnmusicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int quantity = 1;
    Spinner spinner;
    ArrayList instruments;
    ArrayAdapter instrumentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        instruments = new ArrayList();

        instruments.add("guitar");
        instruments.add("sax");
        instruments.add("violin");

        instrumentsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, instruments);
        instrumentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(instrumentsAdapter);
    }

    public void incQuantity(View view) {
        TextView quantityVal = findViewById(R.id.quantityVal);
        ArrayList<Integer> age = new ArrayList<Integer>();
        age.add(1);

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