package com.example.finalpro;

import com.example.finalpro.Client;
import com.example.finalpro.Screening;
import javafx.scene.Parent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

public class Reservation implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;  // unique id


    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private Screening screening;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private Client client;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private String state;

    private LocalDateTime reservationTime;

    private List<Ticket> ticketsList = new ArrayList<>();
    @Getter
    private List<Client> clientList = new ArrayList<>();

    @Getter
    private List<Snacks> snacksList = new ArrayList<>();

    @Getter
    private static List<Reservation> reservationList = new ArrayList<>();

    public Reservation(Screening screening, Client client, String state){
        setScreening(screening);
        setClient(client);
        setState(state);
        setReservationTime();

        reservationList.add(this);

    }

    public static void readFromReservationList(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            reservationList = (List<Reservation>) ois.readObject();
    }

    private void setReservationTime() {
        reservationTime = LocalDateTime.now();
    }

    public void addClient(Client client){
        if(!clientList.contains(client)){
            clientList.add(client);
            client.addReservation(this);
        }

    }
    public void removeClient(Client client){
        if(clientList.contains(client)){
            clientList.remove(client);
            client.removeReservation(this);
        }
    }

    public void addSnack(Snacks snack){
        if(!snacksList.contains(snack)){
            snacksList.add(snack);
        }
    }

    public void removeSnack(Snacks snack){
        if(snacksList.contains(snack)){
            snacksList.remove(snack);
        }
    }

    public  void deleteUnpaidReservation(){
             if(screening.getScreeningDate().isAfter(LocalDateTime.now().minus(15, ChronoUnit.MINUTES)));
                 removeTicketFromReservation(this.ticketsList.get(0));
    }

    public void reserveScreening(){
        this.state = ""+ReservationState.RESERVED;
    }
    public void reserveAndPayForScreening(){
        this.state = ""+ReservationState.PAID;
    }

    public void addTicketToReservation(Ticket ticket) {
        if (!ticketsList.contains(ticket)) {
            ticketsList.add(ticket);
            this.state = ""+ReservationState.RESERVED;
        }
    }


    public void removeTicketFromReservation(Ticket ticket) {
        if (ticketsList.contains(ticket)) {
            ticketsList.remove(ticket);
            ticket.removeScreeningReservation();
        }
    }
}
