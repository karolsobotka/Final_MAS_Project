package com.example.finalpro;

import java.io.Serializable;
import java.time.LocalDate;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id


    private LocalDate purchaseDate;
    private LocalDate screeningDate;
    private int roomNumber;
    private double price;
    private Movie movie;
}
