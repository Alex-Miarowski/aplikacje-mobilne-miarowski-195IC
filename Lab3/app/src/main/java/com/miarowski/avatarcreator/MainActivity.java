package com.miarowski.avatarcreator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    protected boolean wearHat = false;
    protected boolean wearWeapon = false;
    protected String hatName = "";
    protected String weaponName = "";
    protected String className = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wearHat = false;
        wearWeapon = false;
        hatName = "";
        weaponName = "";
        className = "";
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioButtonPutOnHat:
                if (checked)
                    wearHat = true;
                break;
            case R.id.radioButtonTakeOffHat:
                if (checked)
                    wearHat = false;
                break;
            case R.id.radioButtonPutOnWeapon:
                if (checked)
                    wearWeapon = true;
                break;
            case R.id.radioButtonTakeOffWeapon:
                if (checked)
                    wearWeapon = false;
                break;
            default:
                break;
        }
    }

    public void goToAvatarPreview(View view){
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch switchOwnClass = (Switch) findViewById(R.id.switchDefaultOrOwnClass);
        boolean switchOn = switchOwnClass.isChecked();
        if(switchOn){
            EditText chosenClass = (EditText) findViewById(R.id.EditTextOwnClassName);
            className = chosenClass.getText().toString();
            if(wearHat){
                Spinner chosenHat = (Spinner) findViewById(R.id.spinnerChooseHat);
                hatName = chosenHat.getSelectedItem().toString();
            }
            if(wearWeapon){
                Spinner chosenWeapon = (Spinner) findViewById(R.id.spinnerChooseWeapon);
                weaponName = chosenWeapon.getSelectedItem().toString();
            }
        }
        else{
            Spinner chosenClass = (Spinner) findViewById(R.id.spinnerChooseDefaultClass);
            className = chosenClass.getSelectedItem().toString();
            wearHat = true;
            wearWeapon = true;
        }
        Intent intent = new Intent(this, AvatarPreviewActivity.class);
        intent.putExtra("className", className);
        intent.putExtra("hatName", hatName);
        intent.putExtra("weaponName", weaponName);
        intent.putExtra("wearHat", wearHat);
        intent.putExtra("wearWeapon", wearWeapon);
        startActivity(intent);
    }
}