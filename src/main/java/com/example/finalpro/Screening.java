package com.example.finalpro;

public class Screening {


    private String dateFrom;

    private String name;
    private String room;
    private String availability;

    public Screening(String dateFrom, String name, String room, String availability) {
        this.dateFrom = dateFrom;
        this.name = name;
        this.room = room;
        this.availability = availability;
    }


    public String getDateFrom() {
        return dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public String getAvailability() {
        return availability;
    }
}
