package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

public class RegisteredClient extends Client{
    private static final long serialVersionUID = 7526472295622776147L;  // unique id


    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private long creditCardNumber;



    public RegisteredClient(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        super.getClientMap().put(super.getId(), this);

    }
    public RegisteredClient(String firstName, String lastName, LocalDate birthDate, long creditCardNumber) {
        super(firstName, lastName, birthDate);
        setCreditCardNumber(creditCardNumber);
        super.getClientMap().put(super.getId(), this);
    }
}
