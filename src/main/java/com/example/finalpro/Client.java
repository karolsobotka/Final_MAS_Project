package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Client extends Person {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id
    
    @NonNull
    private int id;

    @NonNull
    @Setter(AccessLevel.PRIVATE)
    @Getter
    private String email;

    private Map<Integer, Client> clientList = new HashMap<>();

    public Client(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        setId((int) Math.random()*9999 + 9999);
    }
    public Client(String firstName, String lastName, LocalDate birthDate,String email) {
        super(firstName, lastName, birthDate);
        id = ++id;
        setEmail(email);
    }

    public void confirmReservation(){

    }



    public void setId(int id) {
        if(clientList.containsKey(id)){
            id++;
            setId(id);
        }
        else
            this.id = id;

    }
}
