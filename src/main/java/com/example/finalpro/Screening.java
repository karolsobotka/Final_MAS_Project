package com.example.finalpro;

import com.example.finalpro.Movie;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime screeningDate;
    @Getter
    @Setter
    @NonNull
    private int roomNumber;

    private List<Ticket> ticketsList = new ArrayList<>();
    @Getter
    private static List<Screening> screeningList = new ArrayList<>();


    public Screening(LocalDateTime screeningDate, Movie movie, int room) {
        setScreeningDate(screeningDate);
        setMovie(movie);
        setRoomNumber(room);
        movie.getScreeningList().add(this);
    }

    public static void readFromScreeningList(ObjectInputStream ois) throws IOException, ClassNotFoundException  {
            screeningList = (List<Screening>) ois.readObject();
    }

    public void addTicketToScreening(Ticket ticket) throws Exception {
        if(!ticketsList.contains(ticket)){
            ticketsList.add(ticket);
        }
        else
            throw new Exception("Ticket already in Screening");

    }

    public void removeTicketFromScreening(Ticket ticket){
        if (ticketsList.contains(ticket)) {
            ticketsList.remove(ticket);
           // zajecia.removeKlasaNauczyciel();
        }
    }




}
