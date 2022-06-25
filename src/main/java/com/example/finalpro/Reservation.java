package com.example.finalpro;

import com.example.finalpro.Client;
import com.example.finalpro.Screening;
import javafx.scene.Parent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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

    private LocalDate reservationTime;

    private List<Ticket> ticketsList = new ArrayList<>();
    @Getter
    private List<Client> clientList = new ArrayList<>();

    @Getter
    private List<Snacks> snacksList = new ArrayList<>();


    public Reservation(Screening screening, Client client, String state){
        setScreening(screening);
        setClient(client);
        setState(state);
        setReservationTime();

    }

    private void setReservationTime() {
        reservationTime = LocalDate.parse(LocalDate.now()+" "+ LocalTime.now());
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

    private void deleteUnpaidReservation(){
            // if(screening time < LocalTime - 15 minutes  )
        // remooveTicketFromReservation(ticket???);
    }

    public void reserveScreening(){

    }
    public void reserveAndPayForScreening(){

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
