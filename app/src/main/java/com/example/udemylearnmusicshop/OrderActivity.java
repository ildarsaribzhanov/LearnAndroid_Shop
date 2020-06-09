package com.example.udemylearnmusicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent orderIntent = getIntent();

        order = (Order) orderIntent.getParcelableExtra("order");

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

    public void sendOrder(View view) {
        String message = "User: " + order.userName + "\n" +
                "Instrument: " + order.instrument + "\n" +
                "Amount: " + order.amount.toString() + "\n" +
                "Price One: " + order.cost.toString() + "\n" +
                "Total price: " + order.getTotalPrice().toString();

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