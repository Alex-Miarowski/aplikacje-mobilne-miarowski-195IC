package com.miarowski.avatarcreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class AvatarPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_preview);

        Intent intent = getIntent();
        String className = intent.getStringExtra("className");
        String hatName = intent.getStringExtra("hatName");
        String weaponName = intent.getStringExtra("weaponName");
        boolean wearHat = intent.getBooleanExtra("wearHat", false);
        boolean wearWeapon = intent.getBooleanExtra("wearWeapon", false);

        TextView chosenClass = (TextView) findViewById(R.id.textViewChosenClass);
        chosenClass.setText(className);

        ImageView avatarWeapon = (ImageView) findViewById(R.id.imageViewAvatarWeapon);
        ImageView avatarHat = (ImageView) findViewById(R.id.imageViewAvatarHat);
        ImageView avatarBase = (ImageView) findViewById(R.id.imageViewAvatarBase);

        avatarBase.setImageResource(R.drawable.basic_character);
        avatarBase.setVisibility(View.VISIBLE);

        if(wearHat){
            if(hatName.equals("")){
                avatarHat.setImageResource(setAvatarHat(className));
            }
            else{
                avatarHat.setImageResource(setAvatarHat(hatName));
            }
            avatarHat.setVisibility(View.VISIBLE);
        }
        else{
            avatarHat.setVisibility(View.INVISIBLE);
        }

        if(wearWeapon){
            if(weaponName.equals("")){
                avatarWeapon.setImageResource(setAvatarWeapon(className));
            }
            else{
                avatarWeapon.setImageResource(setAvatarWeapon(weaponName));
            }
            avatarWeapon.setVisibility(View.VISIBLE);
        }
        else{
            avatarWeapon.setVisibility(View.INVISIBLE);
        }
    }

    public void goHome(View view){
        finish();
    }

    private int setAvatarHat(String hatClass){
        switch (hatClass){
            case "Wojownik":
                return R.drawable.hat_warrior;
            case "Mag":
                return R.drawable.hat_wizard;
            case "Łucznik":
                return R.drawable.hat_archer;
            default:
                return 0;
        }
    }

    private int setAvatarWeapon(String weaponClass){
        switch (weaponClass){
            case "Wojownik":
                return R.drawable.weapon_warrior;
            case "Mag":
                return R.drawable.weapon_wizard;
            case "Łucznik":
                return R.drawable.weapon_archer;
            default:
                return 0;
        }
    }

    public void changeBackground(View view){
        boolean isOn = ((CheckBox) view).isChecked();
        ImageView background = (ImageView) findViewById(R.id.imageViewAvatarBackground);
        if(isOn){
            background.setVisibility(View.VISIBLE);
        }
        else{
            background.setVisibility(View.INVISIBLE);
        }
    }
}