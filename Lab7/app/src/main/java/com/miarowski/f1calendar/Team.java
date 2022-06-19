package com.miarowski.f1calendar;

public class Team {

    private int teamLogoResourceId;
    private int carResourceId;
    private String fullTeamName;
    private int firstTeamEntry;
    private int worldChampionships;

    private String driver1Name;
    private String driver2Name;
    private int driver1PhotoResourceId;
    private int driver2PhotoResourceId;

    public Team(int teamLogoResourceId, int carResourceId, String fullTeamName, int firstTeamEntry, int worldChampionships, String driver1Name, String driver2Name, int driver1PhotoResourceId, int driver2PhotoResourceId) {
        this.teamLogoResourceId = teamLogoResourceId;
        this.carResourceId = carResourceId;
        this.fullTeamName = fullTeamName;
        this.firstTeamEntry = firstTeamEntry;
        this.worldChampionships = worldChampionships;
        this.driver1Name = driver1Name;
        this.driver2Name = driver2Name;
        this.driver1PhotoResourceId = driver1PhotoResourceId;
        this.driver2PhotoResourceId = driver2PhotoResourceId;
    }

    public static final Team[] teams = {
            new Team(R.drawable.logo_redbull, R.drawable.car_redbull, "Oracle Red Bull Racing", 1997, 4, "Max Verstappen", "Sergio Perez", R.drawable.verstappen, R.drawable.perez),
            new Team(R.drawable.logo_ferrari, R.drawable.car_ferrari, "Scuderia Ferrari", 1950, 16, "Charles Leclerc", "Carlos Sainz", R.drawable.leclerc, R.drawable.sainz),
            new Team(R.drawable.logo_mercedes, R.drawable.car_mercedes, "Mercedes-AMG Petronas F1 Team", 1970, 8, "Lewis Hamilton", "George Russell", R.drawable.hamilton, R.drawable.russell)
    };

    public int getTeamLogoResourceId() {
        return teamLogoResourceId;
    }

    public int getCarResourceId() {
        return carResourceId;
    }

    public String getFullTeamName() {
        return fullTeamName;
    }

    public int getFirstTeamEntry() {
        return firstTeamEntry;
    }

    public int getWorldChampionships() {
        return worldChampionships;
    }

    public String getDriver1Name() {
        return driver1Name;
    }

    public String getDriver2Name() {
        return driver2Name;
    }

    public int getDriver1PhotoResourceId() {
        return driver1PhotoResourceId;
    }

    public int getDriver2PhotoResourceId() {
        return driver2PhotoResourceId;
    }

    public String toString() {
        return this.fullTeamName;
    }
}
