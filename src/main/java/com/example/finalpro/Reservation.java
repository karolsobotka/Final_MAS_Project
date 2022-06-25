package com.example.finalpro;

import com.example.finalpro.Client;
import com.example.finalpro.Screening;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
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

    private List<Ticket> ticketsList = new ArrayList<>();


    public Reservation(Screening screening, Client client, String state){

    }

    private void deleteUnpaidReservation(){

    }
    public void reserveScreening(){

    }
    public void reserveAndPayForScreening(){

    }
}
