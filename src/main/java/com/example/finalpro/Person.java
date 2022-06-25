package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Person implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id

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



    private static List<Person> personsList = new ArrayList<>();

    public Person(String firstName, String lastName, LocalDate birthDate){
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
    }
    public static List<Person> getPersonsList() {
        return Collections.unmodifiableList(personsList);
    }
    public static void readFromPersonsList(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        personsList = (List<Person>) ois.readObject();
    }
}
