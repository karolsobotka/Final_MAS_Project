package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

public abstract class Person {
    @Getter
    @NonNull
    @Setter(AccessLevel.PRIVATE)
    private String firstName;
    @Getter
    @NonNull
    @Setter(AccessLevel.PRIVATE)
    private String lastName;
    @Getter
    @NonNull
    @Setter(AccessLevel.PRIVATE)
    private LocalDate birthDate;

    public Person(String firstName, String lastName, LocalDate birthDate){
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
    }
}
