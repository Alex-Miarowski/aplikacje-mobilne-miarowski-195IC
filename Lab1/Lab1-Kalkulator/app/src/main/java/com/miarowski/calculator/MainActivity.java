package com.miarowski.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String operation = "";

    public void operationBtnOnClick(View view){
        Button btn = (Button) view;
        operation = btn.getText().toString();
        TextView viewOperation = (TextView) findViewById(R.id.viewOperation);
        viewOperation.setText(operation);
    }

    public void clearBtnOnClick(View view){
        operation = "";
        TextView viewOperation = (TextView) findViewById(R.id.viewOperation);
        TextView viewResult = (TextView) findViewById(R.id.viewResult);
        viewOperation.setText(operation);
        viewResult.setText(operation);
    }

    @SuppressLint("SetTextI18n")
    public void equalBtnOnClick(View view){
        Spinner number1 = (Spinner) findViewById(R.id.spinnerNumber1);
        double value1 = Double.parseDouble(String.valueOf(number1.getSelectedItem()));
        Spinner number2 = (Spinner) findViewById(R.id.spinnerNumber2);
        double value2 = Double.parseDouble(String.valueOf(number2.getSelectedItem()));
        TextView viewResult = (TextView) findViewById(R.id.viewResult);
        double result = 0.0;
        boolean divideByZero = false;

        switch (operation){
            case "÷":
                if(value2 == 0){
                    viewResult.setText("Nie dzielimy przez 0");
                    divideByZero = true;
                }
                else {
                    result = value1 / value2;
                }
                break;
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "×":
                result = value1 * value2;
                break;
            default:
                break;
        }
        if(!divideByZero){
            viewResult.setText(Double.toString(result));
        }
    }

}