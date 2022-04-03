package com.miarowski.komunikator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculatorActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);
        Intent intent = getIntent();
        double userWeight = intent.getDoubleExtra("weight", 0);
        double userHeight = intent.getDoubleExtra("height", 1);
        String result = checkBMI(userWeight, userHeight);

        TextView textHeight = (TextView) findViewById(R.id.textViewHeight);
        TextView textWeight = (TextView) findViewById(R.id.textViewWeight);
        TextView textResult = (TextView) findViewById(R.id.textViewResult);
        textHeight.setText(Double.toString(userHeight));
        textWeight.setText(Double.toString(userWeight));
        textResult.setText(result);

    }

    private String checkBMI(double weight, double height){
        double bmi = weight / Math.pow(height, 2);
        String result;
        if (bmi < 18.5){
            result = "Niedowaga";
        }
        else if (bmi > 24.99){
            result = "Nadwaga";
        }
        else result = "Waga prawidłowa";
        return result;
    }
}