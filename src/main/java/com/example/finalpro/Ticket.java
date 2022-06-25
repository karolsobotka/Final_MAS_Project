package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private LocalDateTime purchaseDate;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private LocalDateTime screeningDate;
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

    @Getter
    private static List<Ticket> ticketList = new ArrayList<>();

    public Ticket(@NonNull LocalDateTime purchaseDate, @NonNull LocalDateTime screeningDate, @NonNull int roomNumber, @NonNull double price, @NonNull Movie movie) {
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

    public static void readFromTicketList(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ticketList = (List<Ticket>) ois.readObject();
    }


}
