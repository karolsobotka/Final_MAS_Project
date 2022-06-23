package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public abstract class Person {
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String firstName;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String lastName;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private LocalDate birthDate;

    public Person(String firstName, String lastName, LocalDate birthDate){

    }
}
