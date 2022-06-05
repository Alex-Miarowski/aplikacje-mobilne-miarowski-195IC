package com.miarowski.f1calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        SQLiteOpenHelper grandPrixDatabaseHelper = new GrandPrixDatabaseHelper(this);
        try {
            SQLiteDatabase db = grandPrixDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("GRANDPRIX",
                                        new String[] {"TRACK_NAME", "GRAND_PRIX_NAME", "RACE_DATE", "FIRST_GRAND_PRIX", "NUMBER_OF_LAPS", "IMAGE_RESORCE_ID", "CIRCUIT_LENGTH_IN_KM", "RACE_DISTANCE_IN_KM"},
                                "_id = ?",
                                        new String[] {Integer.toString(grandPrixId)},
                                        null, null, null);
            if (cursor.moveToLast()){
                String trackNameText = cursor.getString(0);
                String grandPrixNameText = cursor.getString(1);
                String raceDateText = cursor.getString(2);
                int firstGrandPrixText = cursor.getInt(3);
                int numberOfLapsText = cursor.getInt(4);
                int imageResorceIdText = cursor.getInt(5);
                double circuitLengthInKmText = cursor.getDouble(6);
                double raceDistanceInKmText = cursor.getDouble(7);

                ImageView circuit = (ImageView) findViewById(R.id.circuit);
                circuit.setImageResource(imageResorceIdText);

                TextView trackName = (TextView) findViewById(R.id.trackName);
                trackName.setText(trackNameText);

                TextView grandPrixName = (TextView) findViewById(R.id.grandPrixName);
                grandPrixName.setText(grandPrixNameText);

                TextView raceDate = (TextView) findViewById(R.id.raceDate);
                raceDate.setText(raceDateText);

                TextView firstGrandPrix = (TextView) findViewById(R.id.firstGrandPrix);
                firstGrandPrix.setText("Pierwsze Grand Prix: " + firstGrandPrixText);

                TextView numberOfLaps = (TextView) findViewById(R.id.numberOfLaps);
                numberOfLaps.setText("Ilość okrążeń: " + numberOfLapsText);

                TextView circuitLengthInKm = (TextView) findViewById(R.id.circuitLengthInKm);
                circuitLengthInKm.setText("Długość okrążenia w km: " + String.valueOf(circuitLengthInKmText));

                TextView raceDistanceInKm = (TextView) findViewById(R.id.raceDistanceInKm);
                raceDistanceInKm.setText("Długość wyścigu w km: " + String.valueOf(raceDistanceInKmText));
            }
            //cursor.close();
            //db.close();
        } catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}