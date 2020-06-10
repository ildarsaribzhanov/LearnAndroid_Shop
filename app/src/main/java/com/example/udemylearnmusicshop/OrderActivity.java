package com.example.udemylearnmusicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    OrderItm orderItm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent orderIntent = getIntent();

        orderItm = (OrderItm) orderIntent.getParcelableExtra("order");

        setLayoutData(orderItm);
    }

    public void setLayoutData(OrderItm orderItm) {
        TextView userView = findViewById(R.id.orderUserName);
        TextView instrumentView = findViewById(R.id.orderInstrument);
        TextView quantityView = findViewById(R.id.orderAmount);
        TextView priceView = findViewById(R.id.orderPrice);
        TextView TotalPriceView = findViewById(R.id.orderTotalPrice);

        instrumentView.setText(orderItm.instrument);
        quantityView.setText(orderItm.amount.toString());
        priceView.setText(orderItm.cost.toString());
        TotalPriceView.setText(orderItm.getTotalPrice().toString());
    }

    public void sendOrder(View view) {
        String message = "Instrument: " + orderItm.instrument + "\n" +
                "Amount: " + orderItm.amount.toString() + "\n" +
                "Price One: " + orderItm.cost.toString() + "\n" +
                "Total price: " + orderItm.getTotalPrice().toString();

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