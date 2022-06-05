package com.miarowski.f1calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamActivity extends AppCompatActivity {

    public static final String EXTRA_TEAM_ID = "teamId";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int teamId = (Integer)getIntent().getExtras().get(EXTRA_TEAM_ID);
        Team team = Team.teams[teamId];

        ImageView teamLogo = (ImageView) findViewById(R.id.teamLogo);
        teamLogo.setImageResource(team.getTeamLogoResourceId());

        ImageView teamCar = (ImageView) findViewById(R.id.teamCar);
        teamCar.setImageResource(team.getCarResourceId());

        TextView fullTeamName = (TextView) findViewById(R.id.fullTeamName);
        fullTeamName.setText(team.getFullTeamName());

        TextView firstTeamEntry = (TextView) findViewById(R.id.firstTeamEntry);
        firstTeamEntry.setText("Rok pierwszego wyścigu: " + team.getFirstTeamEntry());

        TextView worldChampionships = (TextView) findViewById(R.id.worldChampionships);
        worldChampionships.setText("Wygrane mistrzostwa: " + team.getWorldChampionships());

        TextView driver1Name = (TextView) findViewById(R.id.driver1Name);
        driver1Name.setText(team.getDriver1Name());

        ImageView driver1Photo = (ImageView) findViewById(R.id.driver1Photo);
        driver1Photo.setImageResource(team.getDriver1PhotoResourceId());

        TextView driver2Name = (TextView) findViewById(R.id.driver2Name);
        driver2Name.setText(team.getDriver2Name());

        ImageView driver2Photo = (ImageView) findViewById(R.id.driver2Photo);
        driver2Photo.setImageResource(team.getDriver2PhotoResourceId());
    }

}