package com.example.laura.pizza_v20;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView cardNumber;
    TextView cardDate;
    TextView cardCCV;
    Switch switchEmail;
    TextView email;
    TextView full_amount;
    CheckBox checkBox;
    Spinner spinner;
    String initialValue;
    RadioButton rb;
    RadioButton rb2;
    RadioButton rb3;
    Button btn;
    String payment_kind;


    int ham = 50;
    int mushrooms = 40;
    int pepper = 30;
    int chicken = 60;
    int pineapple = 60;
    int cheese = 25;
    int rad25 = 200;
    int rad30 = 0;
    int rad35 = 0;
    int previous_cost = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardNumber = findViewById(R.id.cardNumber);
        cardCCV = findViewById(R.id.cardCVV);
        cardDate = findViewById(R.id.dateCardEnd);
        full_amount = findViewById(R.id.txtResult);
        full_amount.setText(Integer.toString(0));
        spinner = findViewById(R.id.spinner_pay);
        initialValue = spinner.getSelectedItem().toString();
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener(initialValue));
        cardDate.setVisibility(View.VISIBLE);
        cardNumber.setVisibility(View.VISIBLE);
        cardCCV.setVisibility(View.VISIBLE);
        rb = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb.setChecked(true);
        full_amount = findViewById(R.id.txtResult);
        int all_score = Integer.parseInt((full_amount.getText().toString()));
        all_score = all_score + rad25 - previous_cost;
        previous_cost = rad25;
        full_amount.setText(Integer.toString(all_score));
        rb.setEnabled(false);
    }

    public void checkboxes_onClick(CheckBox checkBox, int amount, TextView textView) {
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

    /*public void radio_buttons_onClick(RadioButton radioButton, int amount, int rad25, int rad30, int rad35, TextView textView) {
        rb = findViewById(R.id.radioButton);
        int all_score = Integer.parseInt((textView.getText().toString()));
        if (rb.isChecked()) {
            all_score = all_score + amount - (rad25*rad25first + rad30*rad30first + rad35*rad35first);
            textView.setText(Integer.toString(all_score));
        }
    }*/

//    public void reset_amount() {
//        if (rad25first == 0) {
//            rad25 = 0;
//        } else {
//            rad25 = 200;
//        }
//        if (rad30first == 0) {
//            rad30 = 0;
//        } else {
//            rad30 = 250;
//        }
//        if (rad35first == 0) {
//            rad35 = 0;
//        } else {
//            rad35 = 300;
//        }
//    }

    public void rb1_onClick(View view) {
        rb2.setEnabled(true);
        rb3.setEnabled(true);
        rb.setEnabled(false);
        full_amount = findViewById(R.id.txtResult);
        int all_score = Integer.parseInt((full_amount.getText().toString()));
        all_score = all_score + rad25 - previous_cost;
        previous_cost = rad25;
        full_amount.setText(Integer.toString(all_score));
    }

    public void rb2_onClick(View view) {
        rb2.setEnabled(false);
        rb3.setEnabled(true);
        rb.setEnabled(true);
        full_amount = findViewById(R.id.txtResult);
        int all_score = Integer.parseInt((full_amount.getText().toString()));
        all_score = all_score + rad30 - previous_cost;
        previous_cost = rad30;
        full_amount.setText(Integer.toString(all_score));
    }

    public void rb3_onClick(View view) {
        rb2.setEnabled(true);
        rb3.setEnabled(false);
        rb.setEnabled(true);
        full_amount = findViewById(R.id.txtResult);
        int all_score = Integer.parseInt((full_amount.getText().toString()));
        all_score = all_score + rad35 - previous_cost;
        previous_cost = rad35;
        full_amount.setText(Integer.toString(all_score));
    }


    public void check_box1_onClick(View view) {
        checkBox = findViewById(R.id.checkBox);
        checkboxes_onClick(checkBox, ham, full_amount);
    }

    public void check_box2_onClick(View view) {
        checkBox = findViewById(R.id.checkBox2);
        checkboxes_onClick(checkBox, mushrooms, full_amount);
    }

    public void check_box3_onClick(View view) {
        checkBox = findViewById(R.id.checkBox3);
        checkboxes_onClick(checkBox, pepper, full_amount);
    }

    public void check_box4_onClick(View view) {
        checkBox = findViewById(R.id.checkBox4);
        checkboxes_onClick(checkBox, chicken, full_amount);
    }

    public void check_box5_onClick(View view) {
        checkBox = findViewById(R.id.checkBox5);
        checkboxes_onClick(checkBox, pineapple, full_amount);
    }

    public void check_box6_onClick(View view) {
        checkBox = findViewById(R.id.checkBox6);
        checkboxes_onClick(checkBox, cheese, full_amount);
    }

    public void button_order_onClick(View view) {
        btn = findViewById(R.id.button);
        CheckBox checkBox1 = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        CheckBox checkBox4 = findViewById(R.id.checkBox4);
        CheckBox checkBox5 = findViewById(R.id.checkBox5);
        CheckBox checkBox6 = findViewById(R.id.checkBox6);
        rb = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        String adds = "";
        String payment;
        String radius;
        payment_kind = spinner.getSelectedItem().toString();

        if (checkBox1.isChecked()) {
            adds += R.string.chb_adds_1 + " ";
        }
        if (checkBox2.isChecked()) {
            adds += R.string.chb_adds_2 + " ";
        }
        if (checkBox3.isChecked()) {
            adds += R.string.chb_adds_3 + " ";
        }
        if (checkBox4.isChecked()) {
            adds += R.string.chb_adds_4 + " ";
        }
        if (checkBox5.isChecked()) {
            adds += R.string.chb_adds_5 + " ";
        }
        if (checkBox6.isChecked()) {
            adds += R.string.chb_adds_6 + " ";
        }

        payment = full_amount.getText().toString();

        if (rb.isChecked()) {
            radius = "25 см";
        } else if (rb2.isChecked()) {
            radius = "30 см";
        } else {
            radius = "35 см";
        }

        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() ||
                checkBox4.isChecked() || checkBox5.isChecked() || checkBox6.isChecked()) {

            Toast toast = Toast.makeText(getApplicationContext(), ("Добавки: " + adds + "\r\n" +
                    "Размер: " + radius + "\r\n" +
                    "Стоимость: " + payment + " руб." + "\r\n" +
                    "Способ оплаты: " + payment_kind), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void switch_email_onClick(View view) {
        switchEmail = findViewById(R.id.email_switch);
        email = findViewById(R.id.email);
        if (switchEmail.isChecked()) {
            email.setVisibility(View.VISIBLE);
        } else {
            email.setVisibility(View.GONE);
        }
    }


    protected class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {

        private SpinnerSelectedListener() {
            super();
        }

        public SpinnerSelectedListener(String initialValue) {
            this();
            this.initialValue = initialValue;
        }

        private String initialValue;


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            final String newValue = spinner.getSelectedItem().toString();
            if (!newValue.equals(initialValue)) {
                switch (newValue) {
                    case "Банковская карта":
                        cardNumber.setHint("Номер карты");
                        cardDate.setVisibility(View.VISIBLE);
                        cardNumber.setVisibility(View.VISIBLE);
                        cardCCV.setVisibility(View.VISIBLE);
                        break;
                    case "Оплата наличными":
                        cardDate.setVisibility(View.GONE);
                        cardNumber.setVisibility(View.GONE);
                        cardCCV.setVisibility(View.GONE);
                        break;
                    case "Яндекс.Деньги":
                        cardNumber.setHint("Номер кошелька Яндекс.Деньги");
                        cardDate.setVisibility(View.GONE);
                        cardNumber.setVisibility(View.VISIBLE);
                        cardCCV.setVisibility(View.GONE);
                        break;
                    case "PayPal":
                        cardNumber.setHint("Номер кошелька PayPal");
                        cardDate.setVisibility(View.GONE);
                        cardNumber.setVisibility(View.VISIBLE);
                        cardCCV.setVisibility(View.GONE);
                        break;
                    default:
                        cardNumber.setHint("Номер бонусной карты");
                        cardDate.setVisibility(View.GONE);
                        cardNumber.setVisibility(View.VISIBLE);
                        cardCCV.setVisibility(View.GONE);
                        break;
                }
                initialValue = newValue;


            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // Maybe useful.
            // initialValue = null;
        }

    }
}



