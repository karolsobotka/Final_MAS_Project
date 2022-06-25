package com.example.finalpro;

import com.example.finalpro.Client;
import com.example.finalpro.Screening;

import java.io.Serializable;

public class Reservation implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id



    private Screening screening;
    private Client client;
    private String state;

    public Reservation(){

    }

    private void deleteUnpaidReservation(){

    }
    public void reserveScreening(){

    }
    public void reserveAndPayForScreening(){

    }
}
