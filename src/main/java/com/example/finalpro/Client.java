package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Client extends Person {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id
    
    @NonNull
    @Getter
    private int id;

    @NonNull
    @Setter(AccessLevel.PRIVATE)
    @Getter
    private String email;

    @Getter
    private Map<Integer, Client> clientMap = new HashMap<>();

    @Getter
    private List<Reservation> reservationList = new ArrayList<>();

    public Client(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        setId((int)(Math.random()* 9999 + 9999));
    }
    public Client(String firstName, String lastName, LocalDate birthDate,String email) {
        super(firstName, lastName, birthDate);
        setId((int) (Math.random() * 9999 + 9999));
        setEmail(email);
    }

    public void confirmReservation(){

    }

    public void addReservation(Reservation reservation){
        if(!reservationList.contains(reservation)){
            reservationList.add(reservation);
            reservation.addClient(this);
        }
    }

    public void removeReservation(Reservation reservation){
        if(reservationList.contains(reservation)){
            reservationList.remove(reservation);
            reservation.removeClient(this);
        }
    }


    public void setId(int id) {
        if(clientMap.containsKey(id)){
            id++;
            setId(id);
        }
        else
            this.id = id;

    }
}
