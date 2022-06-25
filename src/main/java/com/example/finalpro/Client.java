package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Client extends Person {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id

    @NonNull
    @Setter(AccessLevel.PRIVATE)
    private AtomicInteger id;

    @NonNull
    @Setter(AccessLevel.PRIVATE)
    @Getter
    private String email;

    public Client(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        id.getAndIncrement();
    }
    public Client(String firstName, String lastName, LocalDate birthDate,String email) {
        super(firstName, lastName, birthDate);
        id.getAndIncrement();
        setEmail(email);
    }

    public void confirmReservation(){

    }
}
