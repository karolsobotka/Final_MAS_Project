package com.example.finalpro;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

public class UnregisteredClient extends Client {

    @Getter
    @NonNull
    private int phoneNumber;

    public UnregisteredClient(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }
    public UnregisteredClient(String firstName, String lastName, LocalDate birthDate, int phoneNumber) throws Exception {
        super(firstName, lastName, birthDate);
        setPhoneNumber(phoneNumber);
    }

    private void setPhoneNumber(int phoneNumber) throws Exception {
        if(phoneNumber > 999999999 || phoneNumber < 500000000){
            throw new Exception("Provide correct phone number");
        }
        else
            this.phoneNumber = phoneNumber;
    }


}
