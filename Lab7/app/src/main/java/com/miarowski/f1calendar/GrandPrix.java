package com.miarowski.f1calendar;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GrandPrix {
    private String trackName;
    private String grandPrixName;
    private String raceDate;
    private int firstGrandPrix;
    private int numberOfLaps;
    private int imageResourceId;
    private double circuitLengthInKm;
    private double raceDistanceInKm;

    public static final GrandPrix[] grandPrix = {
            new GrandPrix("Bahrain International Circuit", "FORMULA 1 GULF AIR BAHRAIN GRAND PRIX 2022","20/3/2022", 2004, 57,5.412, 308.238, R.drawable.bahrain),
            new GrandPrix("Jeddah Corniche Circuit", "FORMULA 1 STC SAUDI ARABIAN GRAND PRIX 2022","27/3/2022", 2021, 50, 6.174, 308.45, R.drawable.jeddah),
            new GrandPrix("Albert Park Circuit", "FORMULA 1 HEINEKEN AUSTRALIAN GRAND PRIX 2022","10/4/2022", 1996, 58, 5.278, 306.124, R.drawable.australia)
    };

    private GrandPrix(String trackName, String grandPrixName, String raceDate, int firstGrandPrix, int numberOfLaps, double circuitLengthInKm, double raceDistanceInKm, int imageResourceId){
        this.trackName = trackName;
        this.grandPrixName = grandPrixName;
        this.raceDate = raceDate;
        this.firstGrandPrix = firstGrandPrix;
        this.numberOfLaps = numberOfLaps;
        this.circuitLengthInKm = circuitLengthInKm;
        this.raceDistanceInKm = raceDistanceInKm;
        this.imageResourceId = imageResourceId;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getGrandPrixName() {
        return grandPrixName;
    }

    public String getRaceDate() {
        return raceDate;
    }

    public int getFirstGrandPrix() {
        return firstGrandPrix;
    }

    public int getNumberOfLaps() {
        return numberOfLaps;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public double getCircuitLengthInKm() {
        return circuitLengthInKm;
    }

    public double getRaceDistanceInKm() {
        return raceDistanceInKm;
    }

    public String toString(){
        return this.grandPrixName;
    }
}
