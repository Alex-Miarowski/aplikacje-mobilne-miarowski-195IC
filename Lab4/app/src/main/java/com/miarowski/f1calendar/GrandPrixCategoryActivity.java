package com.miarowski.f1calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GrandPrixCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grand_prix_category);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<GrandPrix> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, GrandPrix.grandPrix);
        ListView listGrandPrix = (ListView) findViewById(R.id.list_grand_prix);
        listGrandPrix.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(GrandPrixCategoryActivity.this, GrandPrixActivity.class);
                intent.putExtra(GrandPrixActivity.EXTRA_GRAND_PRIX_ID, (int) id);
                startActivity(intent);
            }
        };
        listGrandPrix.setOnItemClickListener(itemClickListener);
    }
}