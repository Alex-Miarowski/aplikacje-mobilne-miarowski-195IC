package com.miarowski.f1calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor finishedCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupOptionsListView();
        setupFinishedListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupOptionsListView(){
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(MainActivity.this, TeamsCategoryActivity.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(MainActivity.this, GrandPrixCategoryActivity.class);
                    startActivity(intent);
                }
            }
        };

        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }

    private void setupFinishedListView(){
        ListView listFinished = (ListView) findViewById(R.id.list_finished_races);
        try {
            SQLiteOpenHelper grandPrixDatabaseHelper = new GrandPrixDatabaseHelper(this);
            db = grandPrixDatabaseHelper.getReadableDatabase();
            finishedCursor = db.query("GRANDPRIX", new String[] {"_id", "TRACK_NAME"}, "FINISHED = 1",
                                                            null, null, null, null);
            CursorAdapter finishedAdapter = new SimpleCursorAdapter(MainActivity.this,
                                                                    android.R.layout.simple_list_item_1,
                                                                    finishedCursor,
                                                                    new String[]{"TRACK_NAME"},
                                                                    new int[]{android.R.id.text1}, 0);
            listFinished.setAdapter(finishedAdapter);
        } catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }

        listFinished.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, GrandPrixActivity.class);
                intent.putExtra(GrandPrixActivity.EXTRA_GRAND_PRIX_ID, (int) id);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Cursor newCursor = db.query("GRANDPRIX", new String[]{"_id", "TRACK_NAME"}, "FINISHED = 1",
                null, null, null, null);
        ListView listFinished = (ListView) findViewById(R.id.list_finished_races);
        CursorAdapter adapter = (CursorAdapter) listFinished.getAdapter();
        adapter.changeCursor(newCursor);
        finishedCursor = newCursor;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        finishedCursor.close();
        db.close();
    }
}