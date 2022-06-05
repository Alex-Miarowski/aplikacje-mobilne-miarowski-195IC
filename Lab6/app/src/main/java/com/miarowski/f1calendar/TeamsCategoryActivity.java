package com.miarowski.f1calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TeamsCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_category);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<Team> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Team.teams);
        ListView listTeams = (ListView) findViewById(R.id.list_teams);
        listTeams.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(TeamsCategoryActivity.this, TeamActivity.class);
                intent.putExtra(TeamActivity.EXTRA_TEAM_ID, (int) id);
                startActivity(intent);
            }
        };
        listTeams.setOnItemClickListener(itemClickListener);
    }

}