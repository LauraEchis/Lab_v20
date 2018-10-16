package com.example.laura.pizza_v20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView cardNumber;
    TextView cardDate;
    TextView cardCCV;
    Switch switchEmail;
    TextView email;
    TextView full_amount;
    CheckBox checkBox;
    Spinner spinner;

    int ham = 50;
    int mushrooms = 40;
    int pepper = 30;
    int chicken = 60;
    int pineapple = 60;
    int cheese = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        full_amount = findViewById(R.id.txtResult);
        full_amount.setText(Integer.toString(0));

        spinner = findViewById(R.id.spinner_pay);

        final int iCurrentSelection = spinner.getSelectedItemPosition();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                cardNumber = findViewById(R.id.cardNumber);
                cardDate = findViewById(R.id.dateCardEnd);
                cardCCV = findViewById(R.id.cardCVV);
                if (iCurrentSelection == 0) {
                    cardNumber.setVisibility(View.VISIBLE);
                    cardDate.setVisibility(View.VISIBLE);
                    cardCCV.setVisibility(View.VISIBLE);
                } else {
                    cardNumber.setVisibility(View.INVISIBLE);
                    cardDate.setVisibility(View.INVISIBLE);
                    cardCCV.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


    }

    public void checkboxes_clicks(CheckBox checkBox, int amount, TextView textView) {
        if (checkBox.isChecked()) {
            int all_score = Integer.parseInt((textView.getText().toString()));
            all_score = all_score + amount;
            textView.setText(Integer.toString(all_score));
        } else {
            int all_score = Integer.parseInt((textView.getText().toString()));
            all_score = all_score - amount;
            textView.setText(Integer.toString(all_score));
        }
    }

    public void check_box1_onClick(View view) {
        checkBox = findViewById(R.id.checkBox);
        checkboxes_clicks(checkBox, ham, full_amount);
    }

    public void check_box2_onClick(View view) {
        checkBox = findViewById(R.id.checkBox2);
        checkboxes_clicks(checkBox, mushrooms, full_amount);
    }

    public void check_box3_onClick(View view) {
        checkBox = findViewById(R.id.checkBox3);
        checkboxes_clicks(checkBox, pepper, full_amount);
    }

    public void check_box4_onClick(View view) {
        checkBox = findViewById(R.id.checkBox4);
        checkboxes_clicks(checkBox, chicken, full_amount);
    }

    public void check_box5_onClick(View view) {
        checkBox = findViewById(R.id.checkBox5);
        checkboxes_clicks(checkBox, pineapple, full_amount);
    }

    public void check_box6_onClick(View view) {
        checkBox = findViewById(R.id.checkBox6);
        checkboxes_clicks(checkBox, cheese, full_amount);
    }


    public void switch_email_onClick(View view) {
        switchEmail = findViewById(R.id.email_switch);
        email = findViewById(R.id.email);
        if (switchEmail.isChecked()) {
            email.setVisibility(View.VISIBLE);
        } else {
            email.setVisibility(View.INVISIBLE);
        }
    }
}


