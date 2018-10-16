package com.example.laura.pizza_v20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView cardNumber;
    Switch switchEmail;
    TextView email;
    TextView full_amount;
    CheckBox checkBox;

    int ham = 50;
    int mashrooms = 40;
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



    }

    public void checkboxes_clicks(CheckBox checkBox, int amount, TextView textView){
        if (checkBox.isChecked()){
            int all_score = Integer.parseInt((textView.getText().toString()));
            all_score = all_score+amount;
            textView.setText(Integer.toString(all_score));
        } else {
            int all_score = Integer.parseInt((textView.getText().toString()));
            all_score = all_score-amount;
            textView.setText(Integer.toString(all_score));
        }
    }

    public void check_box1_onClick(View view){
        checkBox = findViewById(R.id.checkBox);
        checkboxes_clicks(checkBox, ham, full_amount);
    }

    public void check_box2_onClick(View view){
        checkBox = findViewById(R.id.checkBox2);
        checkboxes_clicks(checkBox, ham, full_amount);
    }

    public void check_box3_onClick(View view){
        checkBox = findViewById(R.id.checkBox3);
        checkboxes_clicks(checkBox, ham, full_amount);
    }

    public void check_box4_onClick(View view){
        checkBox = findViewById(R.id.checkBox4);
        checkboxes_clicks(checkBox, ham, full_amount);
    }

    public void check_box5_onClick(View view){
        checkBox = findViewById(R.id.checkBox5);
        checkboxes_clicks(checkBox, ham, full_amount);
    }

    public void check_box6_onClick(View view){
        checkBox = findViewById(R.id.checkBox6);
        checkboxes_clicks(checkBox, ham, full_amount);
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


