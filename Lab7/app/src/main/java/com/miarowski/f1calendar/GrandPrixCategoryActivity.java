package com.miarowski.f1calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class GrandPrixCategoryActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grand_prix_category);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listGrandPrix = (ListView) findViewById(R.id.list_grand_prix);

        SQLiteOpenHelper grandPrixDatabaseHelper = new GrandPrixDatabaseHelper(this);
        try {
            db = grandPrixDatabaseHelper.getReadableDatabase();
            cursor = db.query("GRANDPRIX", new String[]{"_id", "TRACK_NAME"}, null, null, null, null, null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                                                android.R.layout.simple_list_item_1,
                                                cursor,
                                                new String[]{"TRACK_NAME"},
                                                new int[]{android.R.id.text1},
                                            0);
            listGrandPrix.setAdapter(listAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listGrandPrix, View view, int position, long id) {
                Intent intent = new Intent(GrandPrixCategoryActivity.this, GrandPrixActivity.class);
                intent.putExtra(GrandPrixActivity.EXTRA_GRAND_PRIX_ID, (int) id);
                startActivity(intent);
            }
        };
        listGrandPrix.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}