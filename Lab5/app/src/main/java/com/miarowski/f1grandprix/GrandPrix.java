package com.miarowski.f1grandprix;

public class GrandPrix {
    private String name;
    private String description;

    public static final GrandPrix[] grandPrixes = {
            new GrandPrix("Bahrain International Circuit", "Pierwszy wyścig na torze odbył się w 2004 roku \nKierowcy muszą pokonać 57 okrążen po 5.412km każde \nŁączny dystans wyścigu to 308.238km"),
            new GrandPrix("Jeddah Corniche Circuit", "Pierwszy wyścig na torze odbył się w 2021 roku \nKierowcy muszą pokonać 50 okrążen po 6.174km każde \nŁączny dystans wyścigu to 308.45km"),
            new GrandPrix("Albert Park Circuit", "Pierwszy wyścig na torze odbył się w 1996 roku \nKierowcy muszą pokonać 58 okrążen po 5.278km każde \nŁączny dystans wyścigu to 306.124km"),
    };

    private GrandPrix(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return this.name;
    }
}
