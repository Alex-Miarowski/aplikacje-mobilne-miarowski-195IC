package com.miarowski.f1calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GrandPrixActivity extends AppCompatActivity {

    public static final String EXTRA_GRAND_PRIX_ID = "grandPrixId";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grand_prix);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int grandPrixId = (Integer)getIntent().getExtras().get(EXTRA_GRAND_PRIX_ID);
        GrandPrix grandPrix = GrandPrix.grandPrix[grandPrixId];

        ImageView circuit = (ImageView) findViewById(R.id.circuit);
        circuit.setImageResource(grandPrix.getImageResourceId());

        TextView trackName = (TextView) findViewById(R.id.trackName);
        trackName.setText(grandPrix.getTrackName());

        TextView grandPrixName = (TextView) findViewById(R.id.grandPrixName);
        grandPrixName.setText(grandPrix.getGrandPrixName());

        TextView raceDate = (TextView) findViewById(R.id.raceDate);
        raceDate.setText(grandPrix.getRaceDate());

        TextView firstGrandPrix = (TextView) findViewById(R.id.firstGrandPrix);
        firstGrandPrix.setText("Pierwsze Grand Prix: " + grandPrix.getFirstGrandPrix());

        TextView numberOfLaps = (TextView) findViewById(R.id.numberOfLaps);
        numberOfLaps.setText("Ilość okrążeń: " + grandPrix.getNumberOfLaps());

        TextView circuitLengthInKm = (TextView) findViewById(R.id.circuitLengthInKm);
        circuitLengthInKm.setText("Długość okrążenia w km: " + String.valueOf(grandPrix.getCircuitLengthInKm()));

        TextView raceDistanceInKm = (TextView) findViewById(R.id.raceDistanceInKm);
        raceDistanceInKm.setText("Długość wyścigu w km: " + String.valueOf(grandPrix.getRaceDistanceInKm()));
    }
}