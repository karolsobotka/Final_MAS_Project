package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

public class RegisteredClient extends Client{

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private long creditCardNumber;

    public RegisteredClient(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }
    public RegisteredClient(String firstName, String lastName, LocalDate birthDate, long creditCardNumber) {
        super(firstName, lastName, birthDate);
        setCreditCardNumber(creditCardNumber);
    }
}
