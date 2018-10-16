package com.example.laura.pizza_v20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView cardNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardNumber = (EditText) findViewById(R.id.cardNumber);
        cardNumber.addTextChangedListener(new FourDigitCardFormatWatcher());
    }
}


