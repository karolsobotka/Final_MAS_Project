package com.example.finalpro;

public class Seans {


    private String dateFrom;
    private String dateTo;
    private String name;
    private String room;
    private String availability;

    public Seans(String dateFrom, String dateTo, String name, String room, String availability) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
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
