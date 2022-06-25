package com.example.finalpro;

import com.example.finalpro.Movie;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

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


    public Screening(LocalDate screeningDate, Movie movie, int room) {
        setScreeningDate(screeningDate);
        setMovie(movie);
        setRoomNumber(room);
        movie.getScreeningList().add(this);
    }




}
