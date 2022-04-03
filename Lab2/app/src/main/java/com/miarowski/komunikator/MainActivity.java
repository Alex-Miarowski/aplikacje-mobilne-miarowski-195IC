package com.miarowski.komunikator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCreateMessage(View view){
        EditText textName = (EditText) findViewById(R.id.textName);
        String name = textName.getText().toString();
        if(name.equals("")){
            TextView textWarning = (TextView) findViewById(R.id.textWarning);
            textWarning.setText("Brak imienia");
        }
        else{
            String messageText = name + " życzy smacznej kawusi!";
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, messageText);
            startActivity(intent);
        }
    }

    public void onClickCalculateBMI(View view){
        EditText textHeight = (EditText) findViewById(R.id.textHeight);
        EditText textWeight = (EditText) findViewById(R.id.textWeight);
        if(textHeight.getText().toString().equals("") || textWeight.getText().toString().equals("")){
            TextView textWarning = (TextView) findViewById(R.id.textWarning);
            textWarning.setText("Brak wagi lub wzrostu!");
        }else{
            double userHeight = Double.parseDouble(textHeight.getText().toString());
            double userWeight = Double.parseDouble(textWeight.getText().toString());
            Intent intent = new Intent(this, BMICalculatorActivity.class);
            intent.putExtra("height", userHeight);
            intent.putExtra("weight", userWeight);
            startActivity(intent);
        }
    }
}