package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private LocalDate purchaseDate;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private LocalDate screeningDate;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private int roomNumber;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private double price;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private Movie movie;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private Screening screening;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private Reservation reservation;

    @Getter
    @Setter
    private static double ticketPrice = 15;

    public Ticket(@NonNull LocalDate purchaseDate, @NonNull LocalDate screeningDate, @NonNull int roomNumber, @NonNull double price, @NonNull Movie movie) {
        setPurchaseDate(purchaseDate);
        setRoomNumber(roomNumber);
        setPrice(price);
        setMovie(movie);
        setScreening(ScreeningController.getSelectedScreening());
        //setReservation();
    }
    public void removeScreeningReservation() {
        if(screening == null && reservation == null){
            return;
        }
        if(screening != null){
            screening.removeTicketFromScreening(this);
            screening = null;
        }
        if(reservation != null){
            reservation.removeTicketFromReservation(this);
            reservation = null;
        }
    }


}
