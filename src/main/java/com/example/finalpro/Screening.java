package com.example.finalpro;

import com.example.finalpro.Movie;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Screening implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id


    @Getter
    @Setter
    @NonNull
    private Movie movie;
    @Getter
    @Setter
    @NonNull
    private LocalDate screeningDate;
    @Getter
    @Setter
    @NonNull
    private int roomNumber;
    private List<Ticket> ticketsList = new ArrayList<>();


    public Screening(LocalDate screeningDate, Movie movie, int room) {
        setScreeningDate(screeningDate);
        setMovie(movie);
        setRoomNumber(room);
        movie.getScreeningList().add(this);
    }

    public void addTicketToScreening(Ticket ticket){
        if(!ticketsList.contains(ticket)){
            ticketsList.add(ticket);
        }

    }

    public void removeTicketFromScreening(Ticket ticket){
        if (ticketsList.contains(ticket)) {
            ticketsList.remove(ticket);
           // zajecia.removeKlasaNauczyciel();
        }
    }




}
