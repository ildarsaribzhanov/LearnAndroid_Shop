package com.example.udemylearnmusicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class OrderActivity extends AppCompatActivity {
    Basket basket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent basketIntent = getIntent();

        basket = (Basket) basketIntent.getParcelableExtra("basket");

        setLayoutData(basket);
    }

    public void setLayoutData(Basket basket) {
        TextView orderInfo = findViewById(R.id.orderInfo);

        String infoMessage = "Order.\n\n";

        for (Map.Entry<String, OrderItm> instrument : basket.items.entrySet()) {
            OrderItm orderItm = instrument.getValue();

            infoMessage += "Instrument: " + orderItm.instrument + "\n" +
                    "Quantity: " + orderItm.amount.toString() + "\n" +
                    "Cost: " + orderItm.cost.toString() + "\n" +
                    "Price: " + orderItm.getTotalPrice().toString() + "$\n\n";
        }

        infoMessage += "-----\n\nTotal order price: " + basket.getTotalPrice().toString();

        orderInfo.setText(infoMessage);
    }

    public void sendOrder(View view) {
        String message = "Order:\n\n";

        for (Map.Entry<String, OrderItm> instrument : basket.items.entrySet()) {
            OrderItm orderItm = instrument.getValue();

            message += "Instrument: " + orderItm.instrument + "\n" +
                    "Amount: " + orderItm.amount.toString() + "\n" +
                    "Cost: " + orderItm.cost.toString() + "$\n" +
                    "Total instrument price: " + orderItm.getTotalPrice().toString() + "\n\n";
        }

        message += "-----\n\nTotal order price: " + basket.getTotalPrice().toString();

        Intent sendEmailIntent = new Intent(Intent.ACTION_SENDTO);
        sendEmailIntent.setData(Uri.parse("mailto:"));
        sendEmailIntent.putExtra(Intent.EXTRA_EMAIL, "ildar@saribzhanov.ru");
        sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT, "App Order");
        sendEmailIntent.putExtra(Intent.EXTRA_TEXT, message);

        if (sendEmailIntent.resolveActivity(getPackageManager()) == null) {
            Toast errorToast = Toast.makeText(this, "Not Found send email App", Toast.LENGTH_SHORT);

            errorToast.show();
            return;
        }

        startActivity(sendEmailIntent);
    }
}