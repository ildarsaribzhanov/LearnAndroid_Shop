package com.example.udemylearnmusicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity = 1;
    Spinner spinner;
    ArrayList instruments;
    ArrayAdapter instrumentsAdapter;

    Map<String, Double> goodsMap;
    String instrumentName;
    double priceItm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        instruments = new ArrayList();

        instruments.add("guitar");
        instruments.add("sax");
        instruments.add("violin");

        instrumentsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, instruments);
        instrumentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(instrumentsAdapter);

        goodsMap = new HashMap<String, Double>();
        goodsMap.put("guitar", 500.00);
        goodsMap.put("sax", 800.00);
        goodsMap.put("violin", 900.00);
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

        double priceTotal = priceItm * quantity;
        TextView priceView = findViewById(R.id.priceVal);
        priceView.setText(Double.toString(priceTotal));
    }


    public void decQuantity(View view) {
        TextView quantityVal = findViewById(R.id.quantityVal);
        quantity++;
        quantityVal.setText(Integer.toString(quantity));

        double priceTotal = priceItm * quantity;
        TextView priceView = findViewById(R.id.priceVal);
        priceView.setText(Double.toString(priceTotal));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        instrumentName = spinner.getSelectedItem().toString();
        priceItm = goodsMap.get(instrumentName);

        double priceTotal = priceItm * quantity;

        TextView priceView = findViewById(R.id.priceVal);
        priceView.setText(Double.toString(priceTotal));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}