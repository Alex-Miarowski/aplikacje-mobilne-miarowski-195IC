package com.miarowski.f1calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GrandPrixDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "calendar";
    private static final int DB_VERSION = 1;

    GrandPrixDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateDatabase(db, oldVersion, newVersion);
    }

    private void updateDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE GRANDPRIX (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "TRACK_NAME TEXT, "
                    + "GRAND_PRIX_NAME TEXT, "
                    + "RACE_DATE TEXT, "
                    + "FIRST_GRAND_PRIX INTEGER, "
                    + "NUMBER_OF_LAPS INTEGER, "
                    + "IMAGE_RESORCE_ID INTEGER, "
                    + "CIRCUIT_LENGTH_IN_KM REAL, "
                    + "RACE_DISTANCE_IN_KM REAL);");
            insertGrandPrix(db, "Bahrain International Circuit", "FORMULA 1 GULF AIR BAHRAIN GRAND PRIX 2022","20/3/2022", 2004, 57, R.drawable.bahrain, 5.412, 308.238);
            insertGrandPrix(db, "Jeddah Corniche Circuit", "FORMULA 1 STC SAUDI ARABIAN GRAND PRIX 2022","27/3/2022", 2021, 50,R.drawable.jeddah, 6.174, 308.45);
            insertGrandPrix(db, "Albert Park Circuit", "FORMULA 1 HEINEKEN AUSTRALIAN GRAND PRIX 2022","1/4/2022", 1996, 58, R.drawable.australia, 5.278, 306.124);
        }

        if(oldVersion < 2) {
            ContentValues grandPrixValues = new ContentValues();
            grandPrixValues.put("RACE_DATE", "10/4/2022");
            db.update("GRANDPRIX", grandPrixValues, "TRACK_NAME = ?", new String[]{"Albert Park Circuit"});
        }
    }

    private static void insertGrandPrix(SQLiteDatabase db, String trackName, String grandPrixName, String raceDate,
                                        int firstGrandPrix, int numberOfLaps, int imageResorceID, double circuitLengthInKm, double raceDistanceInKm){
        ContentValues grandPrixValues = new ContentValues();
        grandPrixValues.put("TRACK_NAME", trackName);
        grandPrixValues.put("GRAND_PRIX_NAME", grandPrixName);
        grandPrixValues.put("RACE_DATE", raceDate);
        grandPrixValues.put("FIRST_GRAND_PRIX", firstGrandPrix);
        grandPrixValues.put("NUMBER_OF_LAPS", numberOfLaps);
        grandPrixValues.put("IMAGE_RESORCE_ID", imageResorceID);
        grandPrixValues.put("CIRCUIT_LENGTH_IN_KM", circuitLengthInKm);
        grandPrixValues.put("RACE_DISTANCE_IN_KM", raceDistanceInKm);
        db.insert("GRANDPRIX", null, grandPrixValues);
    }
}
